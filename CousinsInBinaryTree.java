// ###### Approach 1: DFS ########
// Time Complexity: 0(n)
// Space Complexity: O(H)

//Approach:
// We need to find the depth of X and Y if they are same but their parents are different.
// We create 4 global variables parentX,parentY,depthX,depthY
// In the recursive call if we encounter the node to be x, we set the depthX and parent X values
// If the node we encounter is y, then we set depthX and depth Y
// Outside the recursive call, we try to return a boolean value saying return true if ParentX!=ParentY && depthX==depthY else return false

class Solution {
    TreeNode parentX;
    int depthX;
    TreeNode parentY;
    int depthY;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,x,y,0,null); //parent of root is null
        return parentX!=parentY && depthX==depthY; //on the same level parents should be different
        
        
    }
    private void helper(TreeNode root,int x,int y,int depth, TreeNode parent){
        
        if(root==null) return;
        
        if(root.val==x){
            depthX=depth;
            parentX=parent;
        }
        if(root.val==y){
            depthY=depth;
            parentY=parent;
        }
        helper(root.left,x,y,depth+1,root);
        helper(root.right,x,y,depth+1,root);
    }
}