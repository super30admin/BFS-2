// Time Complexity :O(n)
// Space Complexity :O(h) h is height of the tree worst case h=n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    
    TreeNode parentX;
    TreeNode parentY;
    int levelX;
    int levelY;
    boolean flag;
    
    private void dfs(TreeNode root,int level,int x,int y)
    {
        if(root == null) return;
        if(root.left!=null)
        {
            if(root.left.val == x)
            {
                parentX = root;
                levelX = level+1;
            }else if(root.left.val == y){
                parentY = root;
                levelY = level+1;
            }  
        }
        
        if(root.right != null)      
        {
            if(root.right.val == x) 
            {
                parentX = root;
                levelX = level+1;
            }else if(root.right.val == y){
                parentY = root;
                levelY = level+1;
            }  
        }
        
        if(parentX!=null && parentY!=null && parentX==parentY)
        {
            flag = false;
            return;
        }
        dfs(root.left,level+1,x,y);
        dfs(root.right,level+1,x,y);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
       
        flag = true;
        dfs(root,0,x,y);
        if(!flag) return flag;
        if(levelX==levelY && parentX!=parentY)
            return true;
        return false;
    }
}