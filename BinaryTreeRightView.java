//Time: O(N)
//Space: O(Height of the tree)

//DFS
class Solution {
    List<Integer> map;
    public List<Integer> rightSideView(TreeNode root) {
        map = new ArrayList<>();
        helper(root, 0);
        return map;
    }
    private void helper(TreeNode root, int currSum) {
        if(root == null) return;
        // if the current level is equal to list size, we append the item,
        // else we don't care about the other nodes on left of same level
        if(map.size() == currSum)
            map.add(root.val);
        // we keep exploring the right most subtree - especially right most nodes
        helper(root.right, currSum+1);
        helper(root.left, currSum+1);
    }
}

// BFS : Time: O(N) | Space: O(Width of the tree || 2^(height of the tree -1)
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i=0;i<qSize;i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                // when we run into the last element in a level
                // we add it to result to get the right side view of the tree
                if(i == qSize-1) result.add(curr.val);
            }
        }
        return result;
    }
}