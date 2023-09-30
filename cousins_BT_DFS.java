//Time complexity:O(n)
//Space complexity:O(n) 
//Solved steps:
//we here use recusive dfs call passing the parameters root,x,y,lvl,parent not 
//for the particular call we chech if it hits the base case then return
//else if root.val==x then get its parent and lvl
//else if root.val==y then get its parent and lvl
//dfs call to right and left 
//in main iscousins function check for the condition of cousins and return true or false accordingly
class Solution {
    TreeNode x_parent,y_parent;
    int x_lvl,y_lvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        dfs(root,x,y,0,null);
        return (x_lvl==y_lvl)&&(x_parent!=y_parent);
    }
    private void dfs(TreeNode root ,int x,int y,int lvl,TreeNode parent){
        if(root==null){
            return;
        }
        if(root.val==x){
            x_parent=parent;
            x_lvl=lvl;
        }
        if(root.val==y){
            y_parent=parent;
            y_lvl=lvl;
        }
        dfs(root.left,x,y,lvl+1,root);
        dfs(root.right,x,y,lvl+1,root);
    }
}