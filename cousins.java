//Time : O(n)
//Space : O(1)

/**
 *
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
    boolean isCousin =false;
    boolean xFound;
    boolean yFound;
    boolean sameRoot=false;
    int xHeight,yHeight;
    public boolean isCousins(TreeNode root, int x, int y) {

        helper(root,x,y,0);
        if(sameRoot==true){
            return false;
        }
        return isCousin;
    }

    public void helper(TreeNode root,int x,int y,int h){

        if(root==null) return;
        else if(xFound==true && yFound==true) {
            return;
        }
        else if(root.val==x){
            xHeight=h;
            xFound=true;
            if(yFound){
                if(xHeight==yHeight){
                    isCousin=true;
                }
            }
        }else if(root.val==y){
            yHeight=h;
            yFound=true;

            if(xFound){
                if(xHeight==yHeight){
                    isCousin=true;
                }
            }
        }

        if( root.left!=null && root.right!=null){
            if(root.left.val ==x){
                if(root.right.val==y){
                    sameRoot=true;
                }
            }else if(root.left.val==y){
                if(root.right.val==x){
                    sameRoot=true;
                }
            }
        }

        helper(root.left,x,y,h+1);
        helper(root.right,x,y,h+1);
    }

}