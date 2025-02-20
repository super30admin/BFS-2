// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

/* Boolean flag solution */
class Solution {
    boolean flag;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.flag = true;
        dfs(root, 0, x, y);
        if(!flag) return false;
        return x_depth == y_depth;
    }
    private void dfs(TreeNode root, int depth,int x, int y){
        // base
        if(root == null) return;
        //logic
        if(root.val == x){
            x_depth = depth;
        }
        if(root.val == y){
            y_depth = depth;
        }
        if(root.left != null && root.right != null){
            if(root.left.val == x && root.right.val == y){
                flag = false;
            }
            if(root.left.val == y && root.right.val == x){
                flag = false;
            }
        }
        if(flag){
            dfs(root.left, depth + 1, x, y);
        }
        if(flag){
            dfs(root.right, depth + 1, x, y);
        }

    }
}

/*  another Recursive Approach */
class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return x_depth == y_depth && x_parent != y_parent;
    }

    private void dfs(TreeNode root, int depth, TreeNode parent, int x, int y){
        //base
        if(root == null) return;
        //logic
        if(root.val == x){
            x_depth = depth;
            x_parent = parent;
        }
        if(root.val == y){
            y_depth = depth;
            y_parent = parent;
        }

        dfs(root.left, depth + 1, root, x, y);
        dfs(root.right, depth + 1, root, x, y);
    }
}