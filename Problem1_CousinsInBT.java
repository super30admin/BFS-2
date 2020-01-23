/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode xPar;                          //Parent of x
    TreeNode yPar;                          //Parent of y
    int xDepth = -1;                        //Depth of x
    int yDepth = -1;                        //Depth of y
    

    public boolean isCousins(TreeNode root, int x, int y) {
        //to find cousins
        findSiblings(root, 0, x, y, null);
        
        return xPar != yPar && xDepth==yDepth;
    }
    
    private void findSiblings(TreeNode root, int depth, int x, int y, TreeNode parent){
        
        //base case
        if(root==null)
            return;
        
        if(root.val==x){
            xPar=parent;
            xDepth = depth;
        }
        
        if(root.val == y){
            yPar = parent;
            yDepth = depth;
        }
        
        findSiblings(root.left, depth+1, x, y, root);
        findSiblings(root.right, depth+1, x, y, root);
            
        
    }
}