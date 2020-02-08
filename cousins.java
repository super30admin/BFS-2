/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// time: O(n)
// space: O(n) internal stack
    
class Solution {
    TreeNode xparent=null;
    TreeNode yparent=null;
    int xdepth=0;
    int ydepth=0;
    //boolean result=false;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,null,0);
        // checking if they are cousins
        return ((xparent!=yparent) && (xdepth==ydepth));
    }
    // travesring and finding x and y
    private void dfs(TreeNode root,int x,int y,TreeNode parent,int depth)
    {
        if(root==null) return;
        if(root.val==x) 
        {
            xparent=parent;
            xdepth=depth;
        } 
        if(root.val==y) 
        {
            yparent=parent;
            ydepth=depth;
        }
        dfs(root.left,x,y,root,depth+1);
        dfs(root.right,x,y,root,depth+1);
    }
}