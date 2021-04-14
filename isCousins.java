/*
Runtime complexity - O(N) where N is the number of nodes in a tree;
Space Complexity - O(H) where H is the height of the tree
*/

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
class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_depth;
    int y_depth;
    public boolean isCousins(TreeNode root, int x, int y) {
        return iterative( root,  x, y);
        //dfs(root,null,x,y,0);
        //return x_depth==y_depth && x_parent!=y_parent;
    }
    
    public void dfs(TreeNode root,TreeNode parent,int x,int y,int depth)
    {
        if(root==null)
            return;
        if(root.val==x)
        {
            x_parent=parent;
            x_depth=depth;
        }
        if(root.val==y)
        {
            y_parent=parent;
            y_depth=depth;
        }
        
        dfs(root.left,root,x,y,depth+1);
        dfs(root.right,root,x,y,depth+1);
    }
    
    public boolean iterative(TreeNode root, int x,int y)
    {
        if(root==null)
            return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            boolean x_found=false;
            boolean y_found=false;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=queue.poll();
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
                    if((curr.left.val==x && curr.right.val==y)||(curr.left.val==y && curr.right.val==x))
                        return false;
                }
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
                if(x_found&&y_found)
                    return true;
                if(x_found || y_found)
                    return false;
            
        }
        return false;
    }
}
