//Time Complexity:O(V+E)
//Space complexity:O(V+E)
//In this problem, I'll be writing a helper function that will check if the given root value is equal to my x or y and update their respective parents and depths in a recursive fashion. If both the depts are same and if both their parents are different, I would return them as true. Else, I would be returning false.
//This problem was executed successfully and got accepted in leetcode. 

class Solution {
    int xdep=-1;
    int ydep=-1;
    TreeNode xpar=null;
    TreeNode ypar=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root,x,y,0,null);
        return xdep==ydep&&xpar!=ypar?true:false;
    }
    private void dfs(TreeNode root,int x ,int y, int depth,TreeNode par){
        if(root==null){
            return;
        }
        if(root.val==x){
            xpar=par;
            xdep=depth;
        }
        else if(root.val==y){
            ypar=par;
            ydep=depth;
        }
        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
        
    }
}