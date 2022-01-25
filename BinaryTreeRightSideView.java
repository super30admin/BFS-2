/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using BFS
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            List<Integer> list = new ArrayList<>();
            return list;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode temp = queue.remove();
                if(size == 1) {
                    list.add(temp.val);
                }
                if(null != temp.left) {
                    queue.add(temp.left);
                }

                if(null != temp.right) {
                    queue.add(temp.right);
                }
                size--;
            }
        }
        return list;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(h), where h is height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    // Approach - Using DFS
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if(root == null) return;

        if(level == result.size()) {
            result.add(root.val);
        }
        result.set(level, root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);

    }
}