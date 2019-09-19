//Time complexity: O(V+E) => O(N)
//Space Complexity: O(V+E) => O(N)
//Tried on leetcode and accepted
//attempts: 3
class Solution {
    //set xdep and ydep to -1
    int xdep = -1;
    int ydep = -1;
    //set xpar and ypar to null as it will initially be null
    TreeNode xpar=null;
    TreeNode ypar=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        //call the function to find depth and parent of the node
        //root as node, depth initially 0 x and y and parent initially null
        finddepthandpar(root,0,x,y,null);
        //If the depth of both x and y are equal and both are having different parent node then retun true else false
        return xdep == ydep && xpar!=ypar;
    }
    //function to find depth and parent of given node
    public void finddepthandpar(TreeNode root,int depth,int x,int y,TreeNode parent)
    {
        //If the root itself null then just return
        if(root==null)
            return;
        //If the value of root is y 
        if(root.val==y)
        {
            //find depth of y and parent of y
            ydep= depth;
            ypar=parent;
        }
        //if the root val is x
        if(root.val==x)
        {
            //Find depth of x and parent of x
            xdep = depth;
            xpar = parent;
        }
        //perform this recursively for the left and right children of these nodes
        finddepthandpar(root.left,depth+1,x,y,root);
        finddepthandpar(root.right,depth+1,x,y,root);
    }
}