// Time Complexity : O(n), where n->nodes in the tree
// Space Complexity : O(n), where n->nodes in the tree
// Three line explanation of solution in plain english

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

class Parent{
    Integer x, y, heightX, heightY;
    Parent(){
        this.x=null;
        this.y=null;
        this.heightX=null;
        this.heightY=null;
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Parent p = new Parent();
        helper(root,x,y,p,-1,0);
        return p.x!=null && p.y!=null && p.x!=p.y && p.heightX==p.heightY;
    }
    
     public void helper(TreeNode root, Integer x, Integer y, Parent p, Integer prev, Integer height) {
         if(root==null)
             return ;
         if(root.val==x){
             p.x=prev;
             p.heightX=height;
             return;
         }
         else if(root.val==y){
             p.y=prev;
             p.heightY=height;
             return;
         }
         helper(root.left,x,y,p,root.val,height+1);
         helper(root.right,x,y,p,root.val,height+1);
     }
}

// Time Complexity : O(n), where n->nodes in the tree
// Space Complexity : O(n2^height)
// Three line explanation of solution in plain english

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

class Parent{
    Integer x, y, heightX, heightY;
    Parent(){
        this.x=null;
        this.y=null;
        this.heightX=null;
        this.heightY=null;
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // Parent p = new Parent();
        // helper(root,x,y,p,-1,0);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Integer valX=null, valY=null;
            for(int i=0;i<size;i++){
               
                TreeNode tmp = q.poll();
                if(tmp==null)
                    continue;
                TreeNode left = tmp.left;
                TreeNode right = tmp.right;
            
                if(left!=null && right!=null){
                    if((left.val==x && right.val==y) || (left.val==y && right.val==x))
                        return false;
                }
                if(tmp.val==x){
                    valX = x;
                }
                if(tmp.val==y){
                    valY = y;
                }
                
                if(valX!=null && valY!=null)
                    return true;
                
                if(left!=null)
                    q.add(left);
                if(right!=null)
                    q.add(right);
            }
        }
        return false;
    }
    }