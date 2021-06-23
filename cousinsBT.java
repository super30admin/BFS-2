//time complexity:O(n)
//space complexity:O(h)
class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,null,0,x,y);
        return x_depth==y_depth && x_parent!=y_parent;
    }//return if the element is at the same level and has different parents
    private void dfs(TreeNode root, TreeNode parent, int depth, int x,int y)
    {
        if(root==null) return;
        if(x==root.val)
        {
            x_depth=depth;//if x is found store the level and 
            //parent value
            x_parent=parent;
        }
        if(y==root.val)
        {
            y_depth=depth;//if y is found store the level and 
            //parent value
            y_parent=parent;
        }
        dfs(root.left, root,depth+1,x,y);//recursive call on left
        dfs(root.right, root,depth+1,x,y);//recursive call on right
    }
}