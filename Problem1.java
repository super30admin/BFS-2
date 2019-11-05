/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Algorithm:
    - Get the height of both x and y.
    - Check whether x and y are having the same parent
    - If heights of both x and y are equal and both do not have the same parent then return true else return false.
*/
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        return (getHeight(root,x,1)==getHeight(root,y,1))&&(!sameParent(root,x,y));
        
    }
    
    private int getHeight(TreeNode root, int y,int v){
        
        if(root==null)
            return 0;
        if(root.val==y)
            return v;
        int found = getHeight(root.left,y,v+1);
        if(found!=0)
            return found;
        return getHeight(root.right,y,v+1);

    }
    
    private boolean sameParent(TreeNode root, int x, int y){
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
            return false;
        if(root.left==null)
            return sameParent(root.right, x,  y);
        if(root.right ==null)
            return sameParent(root.left,  x, y);
        if((root.left.val==x && root.right.val==y)||(root.left.val==y && root.right.val==x))
            return true;
        return (sameParent(root.left, x, y)||sameParent(root.right,x,y));
       
    }
}