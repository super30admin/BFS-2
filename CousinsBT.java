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

/* Approach 1 - BFS
TC: O(n)
SC: O(n)
*/
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for (int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                if(curr.val == x){
                    x_found = true;
                }
                if(curr.val == y){
                    y_found = true;
                }
                if(curr.left!=null && curr.right!=null){
                    //check if they are siblings
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }
                if (curr.left != null){
                    q.add(curr.left);
                }
                if (curr.right != null){
                    q.add(curr.right);
                }

            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
       return false; 
    }
}

/*
Approach 2 - DFS
TC: O(n)
SC: O(h)
*/
class Solution {
    TreeNode parent_x;
    TreeNode parent_y;
    int depth_x;
    int depth_y;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, null, x, y);
        return depth_x == depth_y && parent_x != parent_y;
        
        }
    private void dfs( TreeNode root, int depth, TreeNode parent, int x, int y){
        if(root == null) return;
        if(root.val == x ){
            depth_x = depth;
            parent_x = parent;
        }
        if(root.val == y){
            depth_y = depth;
            parent_y = parent;
        }
        dfs(root.left, depth+1,root, x, y);
        dfs(root.right, depth+1,root, x, y);
    }
    
}