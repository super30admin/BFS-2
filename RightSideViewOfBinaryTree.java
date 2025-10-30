// 199. Binary Tree Right Side View
// https://leetcode.com/problems/binary-tree-right-side-view/description/



// Solution 1 => DFS

/** 
 * Time Complexity: O(n) since we process every node
 * Space Complexity: O(h) height of the tree
 */


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        helper(root, 0, result);

        return result;
    }

    private void helper(TreeNode root, int level, List<Integer> result){
        // base condition
        if(root == null){
            return;
        }

        // logic
        if(result.size() == level){ // since we start our level from 0, if result size is equal to level, we dont have elements sotred for that level
            result.add(root.val);
        }
 
        helper(root.right, level + 1, result); // since we want right view, move to right sub-tree first
        helper(root.left, level + 1, result);
    }
}


// Solution 2 => BFS

/** 
 * Time Complexity: O(n) since we process every node
 * Space Complexity: O(n / 2) = o(n) since max nodes would be at last level so queue would take n/2 space
 */


class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();  // size to remove only those elements which are on current level

            for(int i = 0 ; i < size ; i++){

                TreeNode currNode = q.poll();

                if(i == size - 1){ // if it's the last element of level, add to result (for right side view)
                    result.add(currNode.val);
                }

                if(currNode.left != null){
                    q.add(currNode.left);
                }

                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

        return result;

    }
}