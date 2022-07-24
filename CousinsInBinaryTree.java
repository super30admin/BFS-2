/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    int x_par_val;
    int y_par_val;
    public boolean isCousins(TreeNode root, int x, int y) {
       x_par_val=x;
       y_par_val=y;
        if(root== null || x==y)
        {
            return false;
        }

        dfs(root,0,null);
        return x_depth == y_depth && x_parent !=y_parent;
    }
    private void dfs(TreeNode root, int lvl, TreeNode parent)
    {
        if(root == null )
        {
            return;
        }
        if(root.val== x_par_val)
        {
            x_depth=lvl;
            x_parent=parent;
        }
         if(root.val== y_par_val)
        {
            y_depth=lvl;
            y_parent=parent;
        }
        dfs(root.left,lvl+1,root);
        dfs(root.right,lvl+1,root);
    }
}*/
// BFS
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root== null || x==y)
        {
            return false;
        }
        Queue< TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            boolean x_found=false;
            boolean y_found=false;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr.val==x)
                {
                    x_found=true;
                }
                if(curr.val==y)
                {
                    y_found=true;
                }
                if(curr.left!=null && curr.right!=null)
                {
                    if(curr.left.val==x && curr.right.val==y)
                    {
                        return false;
                    }
                    if(curr.left.val==y && curr.right.val==x)
                    {
                        return false;
                    }
                }
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
            if(x_found == true && y_found == true)
            {
                return true;
            }
            if(x_found == true || y_found == true)
            {
                return false;
            }


        }
        return false;
    }
}



