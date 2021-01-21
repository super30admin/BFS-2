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
// bfs solution
// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i=0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.val == x)
                    x_found = true;
                if(temp.val == y)
                    y_found = true;
                if(temp.left != null && temp.right != null){
                    if(temp.left.val == x && temp.right.val == y)
                        return false;
                    if(temp.left.val == y && temp.right.val == x)
                        return false;
                }
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            if(x_found && y_found)
                return true;
            if(x_found || y_found)
                return false;
        }
        return false;
    }
}

/*
// dfs traversal
// Time Complexity : O(N)
// Space Complexity : O(h) h is height of recursive stack
// Did this code successfully run on Leetcode : Yes
class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_height;
    int y_height;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        dfs(root, x, y, 0, null);
        return x_parent != y_parent && x_height == y_height;
    }
    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent){
        if(root == null)
            return;
        
        if(root.val == x){
            x_parent = parent;
            x_height = level;
        }
        if(root.val == y){
            y_parent = parent;
            y_height = level;
        }
        dfs(root.left, x, y, level+1, root);
        dfs(root.right, x, y, level+1, root);
        return;
    }
}
*/