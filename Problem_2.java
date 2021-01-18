// Time Complexity :o(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//First of all I find out the parents of both the integers and compared if they are same or not.
//if they are not same then I used the hashmap to store the levels of both the integers.
//and at the end check if levels of both the integers are same or not.

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
    //boolean isValid;
    HashMap<Integer,Integer> hash;
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode parentX=getParent(root,root,x);
        TreeNode parentY=getParent(root,root,y);
        // System.out.println(parentX.val);
        // System.out.println(parentY.val);
        hash=new HashMap<Integer,Integer>();
        if(parentX==parentY){
            return false;
        }
        maplevel(root,x,y,1);
        if(hash.get(x)!=hash.get(y)){
            return false;
        }
        //System.out.println(hash);
        return true;
    }
    
    public void maplevel(TreeNode root,int x,int y,int level){
        if(root==null){
            return;
        }
        if(root.val==x || root.val==y){
            hash.put(root.val,level);
        }
        maplevel(root.left,x,y,level+1);
        maplevel(root.right,x,y,level+1);
    }
    
    public TreeNode getParent(TreeNode root,TreeNode parent,int value){
        if(root==null){
            return null;
        }
        if(root.val==value){
            return parent;
        }
        TreeNode par=root;
        TreeNode parentNode=getParent(root.left,par,value);
        if(parentNode!=null){
            return parentNode;
        }
         parentNode=getParent(root.right,par,value);
        return parentNode;
    }
    
}
