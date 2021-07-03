// Time Complexity :O(n) n - number of tree nodes
// Space Complexity :O(h) recursion stack height
// Did this code successfully run on Leetcode :yes 
class Solution {
    TreeNode xP; int xD;
    TreeNode yP; int yD;
    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root,null,x,y,0);
        return xP!=yP && xD==yD;
    }
    private void helper(TreeNode root,TreeNode parent, int x,int y,int Depth)
    {
        if(root==null) return;
        if(root.val==x)
        {
            xP=parent;
            xD=Depth;
            
        }
        if(root.val==y)
        {
            yP=parent;
            yD=Depth;
            
        }
        helper(root.left,root,x,y,Depth+1);
        helper(root.right,root,x,y,Depth+1);
        
    }
}
/* BFS 
class Solution {
    TreeNode xP; int xD;
    TreeNode yP; int yD;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            boolean xLevel=false; 
            boolean yLevel=false;
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                if(temp.val==x)xLevel=true;
                if(temp.val==y)yLevel=true;
                if(temp.left!=null && temp.right!=null)
                { 
                    if(temp.left.val==x && temp.right.val==y)
                        return false;
                    if(temp.left.val==y && temp.right.val==x)
                        return false;
                }
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            
            if(xLevel && yLevel) return true;
            if(xLevel || yLevel) return false;
        }
        return false;
    }

}
*/