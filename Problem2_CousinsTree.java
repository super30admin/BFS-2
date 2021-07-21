// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    
    //BFS using queue
    /*
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null || root.val==x || root.val==y)
            return false;
        
        
       Queue<TreeNode> queue= new LinkedList<>();
        
        queue.add(root);
        boolean XFound=false,YFound=false;
        
        while(!queue.isEmpty())
        {
            int currSize=queue.size();
            
            for(int i=0;i<currSize;i++)
            {
                TreeNode currNode=queue.poll();
                
                
                if(currNode.val==x)
                    XFound=true;
                if(currNode.val==y)
                    YFound=true;
                
                //sibling check
                if(currNode.left!=null && currNode.right!=null)
                {
                    if((currNode.left.val==x && currNode.right.val==y) || (currNode.left.val==y && currNode.right.val==x))
                    return false;
                }
               
                if(currNode.left!=null)
                    queue.add(currNode.left);
                if(currNode.right!=null)
                    queue.add(currNode.right);
              
            }
             if(XFound==true && YFound==true) // if x and y are same level coz level iteration is finished
                   return true;
            
            if(XFound==true || YFound==true)
                return false;
        }
        
        return false;
    }
    */
    
    // DFS using recursion using depth level at each call
    TreeNode xParent,yParent;
    boolean xFound,yFound;
    int xlevel,ylevel;
    public boolean isCousins(TreeNode root, int x, int y)
    {
        if(root==null)
            return false;
        
        dfs(root,0,null,x,y);
        return xlevel==ylevel && xParent!=yParent;
    }
    
    private void dfs(TreeNode root,int level,TreeNode parent,int x,int y)
    {
        if(root==null)
            return;
        
        if(xFound&&yFound)
            return;
        
        if(root.val==x)
        {
            xlevel=level;
            xParent=parent;
            xFound=true;
        }
        
        if(root.val==y)
        {
            ylevel=level;
            yParent=parent;
            yFound=true;
        }
        
        dfs(root.left,level+1,root,x,y);
        dfs(root.right,level+1,root,x,y);
    }
}