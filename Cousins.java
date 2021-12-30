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
//T.C = O(n)
//S.C =O(n)
class Solution {
    // TreeNode x_parent,y_parent;
    // int x_level,y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
        {
            return false;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        boolean x_found = false;
        boolean y_found = false;
        int size;
        while(!q.isEmpty())
        {
            size = q.size();
            while(size!=0)
            {
                TreeNode curr = q.poll();
                if(curr.val == x)
                {
                    x_found = true;
                }
                
                if(curr.val == y)
                {
                    y_found = true;
                }
                
                if(curr.left!=null && curr.right!=null && curr.left.val == x && curr.right.val==y)
                {
                    return false;
                }
                if(curr.left!=null && curr.right!=null && curr.right.val == x && curr.left.val==y)
                {
                    
                       return false;
                   }
                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
                
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
                size--;
            }
            if(x_found && y_found)
            {
                return true;
            }
            
            if(x_found || y_found)
            {
                return false;
            }
        }
        
//         helper(root,0,null,x,y);
//         return x_parent!=y_parent && x_level==y_level;
        
//     }
    
//     private void helper(TreeNode root, int lvl, TreeNode parent,int x , int y)
//     {
//         if(root==null)
//         {
//             return;
//         }
        
//         if(root.val==x)
//         {
//             x_parent=parent;
//             x_level = lvl;
//         }
        
//         if(root.val==y)
//         {
//             y_parent=parent;
//             y_level = lvl;
//         }
        
//         helper(root.left, lvl+1 , root , x ,y);
//         helper(root.right,lvl+1,root,x,y);
//     }
        return true;
    }
}