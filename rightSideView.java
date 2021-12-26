// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Time Complexity = O(n)
// Space Complexity = O(n)
// BFS Solution: Use a queue to add nodes in each level, and maintain a size variable to keep track of the number of the elements in each level
// and iterate over those elements & add them to the result if its the last element in that level
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if (i==size-1) {
                    result.add(node.val);
                }
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return result;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(h)
// DFS Solution: Use recursive system stack and maintain a local variable level to keep track of the level and add it to the result if you found an element in that level for the first time i.e., if(level == result.size()), but make sure you are calling the recursive function on the right side of the node.
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return result;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        // base
        if (root == null) return;

        // logic
        if (level == result.size()) {
            result.add(root.val);
        }

        // recurse
        if (root.right != null) {
            dfs(root.right, level+1);
        }

        if (root.left != null) {
            dfs(root.left, level+1);
        }
    }
}