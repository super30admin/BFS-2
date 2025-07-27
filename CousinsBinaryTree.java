// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : iterate through the tree while maintaining a level variable. If x or y is found set their level. If level 
/// is same and theirr parent is not same return true, else return false;
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
    boolean flag;
    int xDepth = -1;
    int yDepth = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x){
            xDepth = 0;
        }
        if(root.val == y){
            yDepth = 0;
        }
        helper(root, 0, x, y);
        System.out.println(xDepth+" "+yDepth);
        return xDepth!=-1 && xDepth == yDepth;
    }
    public void helper(TreeNode root, int level, int x, int y){
        if(root==null){
            return;
        }
        if(xDepth!=-1 && yDepth!=-1){
            return;
        }
        if(root.left!=null && root.right!=null && ((root.left.val==x && root.right.val==y) || (root.left.val==y && root.right.val==x)) ){
            return;
        }
        System.out.println("AT "+root.val);
        if(root.left!=null)
        {
            System.out.println("left child "+root.left.val);
            if(root.left.val == x){
                System.out.println("Found x at "+(level+1));
                xDepth = level+1;
            }else if(root.left.val==y){
                System.out.println("Found y at "+(level+1));
                yDepth = level+1;
            }
        }
        if(root.right!=null){
            System.out.println("right child = "+root.right.val);
            if(root.right.val == x){
                System.out.println("Found x at "+(level+1));
                xDepth = level+1;
            }else if(root.right.val==y){
                System.out.println("Found y at "+(level+1));
                yDepth = level+1;
            }
        }
        helper(root.left, level+1, x,y);
        helper(root.right, level+1,x,y);
        return;
    }
}