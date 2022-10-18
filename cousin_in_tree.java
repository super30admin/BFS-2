// TC - O(n)
// SC - O(h)
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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] level = {-1,-1};
        TreeNode[] parent = {null,null};
        findCousin(root,x,y,level,parent,1,null);
        
        if(level[0]==level[1] && (parent[0]!=parent[1])) return true;
        
        return false;
    }
    
    public void findCousin(TreeNode root,int x,int y, int[] level,TreeNode[] parent,int currlevel, TreeNode currparent){
        
        if(root==null) return;
        
        if(root.val == x){
            level[0] = currlevel;
            parent[0] = currparent;
        }
        if(root.val == y){
            level[1] = currlevel;
            parent[1] = currparent;
        }
        
        findCousin(root.left,x,y,level,parent,currlevel + 1, root);
        findCousin(root.right,x,y,level,parent,currlevel + 1, root);
        return;
    }
}