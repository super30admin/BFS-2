# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode cur=q.poll();
                //here also we are checking the level
                if(i==n-1)
                {
                    result.add(cur.val);
                }
                 if(cur.left!=null)
                {
                    q.add(cur.left);
                }
                if(cur.right!=null)
                {
                    q.add(cur.right);
                   
                }
               
            }
        }
return result;
    }
}


## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)


lass Solution {
    TreeNode x_parent,y_parent;
    int x_level,y_level;

    public boolean isCousins(TreeNode root, int x, int y) {
      if(root==null) return false;
      
x_level=y_level=0;
dfs(root, 0,null,x,y);
return (x_level==y_level)&&(x_parent!=y_parent);
    }
    private void dfs(TreeNode root, int lvl,TreeNode parent, int x,int y)
    {
        if(root==null) return;
        if(root.val==x)
        {
            x_parent=parent;
            x_level=lvl;
        }
        if(root.val==y)
        {
            y_parent=parent;
            y_level=lvl;
        }
      
        dfs(root.left,lvl+1,root,x,y);
        dfs(root.right,lvl+1,root,x,y);
    }
}



