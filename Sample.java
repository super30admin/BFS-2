# BFS-2

## Problem1 Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

BFS solution:
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(i==size-1)
                {
                    result.add(curr.val);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return result;
    }
}




DFS solution:
class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return result;
        dfs(root,0);
        return result;
        
    }
    private void dfs(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(level==result.size())
        {
            result.add(root.val);
        }
        dfs(root.right,level+1);
        dfs(root.left,level+1);
        
    }
}




## Problem2 Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

BFS solution:
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            boolean x_found=false;
            boolean y_found=false;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr.val==x) x_found=true;
                if(curr.val==y) y_found=true;
                if(curr.left!=null && curr.right!=null)
                {
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
                }
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            if(x_found && y_found)  return true;
            if(x_found || y_found)  return false;
        }
        return false;
    }
}




DFS solution:
class Solution{
        int x_depth,y_depth;
        TreeNode x_parent,y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        dfs(root,0,null,x,y);
        return x_depth==y_depth && x_parent!=y_parent;
    }
    private void dfs(TreeNode root,int depth,TreeNode parent,int x, int y)
    {
        //base
        if(root==null)  return;
        //logic
        if(root.val==x)
        {
            x_depth=depth;
            x_parent=parent;
        }
        if(root.val==y)
        {
            y_depth=depth;
            y_parent=parent;
        }
        dfs(root.left,depth+1,root,x,y);
        dfs(root.right,depth+1,root,x,y);
    }
}


