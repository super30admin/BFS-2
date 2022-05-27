class Solution {
    // DFS solution
    // Time complexity is O(n)
    // Space complexity is O(h)
    // This solution is submitted on leetcode with zero errors
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private int x_level;
    private int y_level;
    private TreeNode x_parent;
    private TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        //edge case
        if(root == null) return true;
        dfs(root, null, x, y, 0);
        if((x_level== y_level) && (x_parent!=y_parent)) return true;
        return false;
    }
    private void dfs(TreeNode root, TreeNode parent, int x, int y, int level){
        // base case
        if(root == null) return;
        //logic
        if(x == root.val){
            x_level = level;
            x_parent = parent;
        }
        if(y == root.val){
            y_level = level;
            y_parent = parent;
        }
        dfs(root.left, root, x, y, level+1);
        dfs(root.right, root, x, y, level+1);
    }
}