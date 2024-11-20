// Time Complexity : O(n). n is the number of nodes in a tree
// Space Complexity : O(n).
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
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null) return false;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        
        while(!q.isEmpty()){
            int size = q.size();            
            boolean xFound=false,yFound=false;
            for(int i=0;i<size;i++){
                TreeNode top = q.poll();
                
                //checking if x and y have same parent
                if(top.left!=null && top.right!=null){
                    
                    if(top.left.val==x && top.right.val==y) return false;
                    if(top.left.val==y && top.right.val ==x) return false;

                }
                
                
                if(top.left!=null){
                    q.add(top.left);
                    if(x==top.left.val){
                      xFound=true;  
                    }     
                    if(y==top.left.val) yFound=true;
                }
                if(top.right!=null){
                  q.add(top.right);
                   if(x==top.right.val){
                      xFound=true;  
                    }     
                    if(y==top.right.val) yFound=true;
                } 
            }
            if(xFound==true && yFound==true) return true;
            if(xFound || yFound) return false;
            
        }
        return false;
    }
}

