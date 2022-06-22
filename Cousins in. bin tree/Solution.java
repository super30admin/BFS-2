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
// Time Complexity:O(n)
// Space Complexity:O(n)
class Solution {
    class Pair {
        TreeNode parent;
        int level;
        
        public Pair(TreeNode p,int l){
            this.parent=p;
            this.level=l;
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        int level=0;
         Pair p1 = helper(root,x,null,level+1);
        Pair p2 = helper(root,y,null,level+1);
        if(p1.parent!=p2.parent && p1.level==p2.level){
            return true;
        }
        return false;
    }
    
    private Pair helper(TreeNode root, int target,TreeNode parent, int level){
        if(root == null) return null;
        if(root.val==target){
            return new Pair(parent,level);
        }
        
        Pair left = helper(root.left,target,root,level+1);
        Pair right = helper(root.right,target,root,level+1);
        
        return left==null ? right : left;
    }
}
