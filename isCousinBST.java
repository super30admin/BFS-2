// Time Complexity : O(n) no of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : too almost one hour to get to the solution


// Your code here along with comments explaining your approach
1. search x and y in left side and save the depth do same in other part
2. compare depth and parents and return result

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
    int depth1 = -1;
     int depth2 = -1;
    
    TreeNode parent1 = null;
    TreeNode parent2 = null;
   
    public boolean isCousins(TreeNode root, int x, int y) {
        
       getDepth(root, x,y, 0,null);
           
       return depth1 == depth2 && parent1 != parent2;
        
    }
    
    private void getDepth(TreeNode root, int x, int y, int level, TreeNode parent)
    {
        if(root == null) 
            return ;
    
        getDepth( root.left,  x,  y, level +1, root);
        
            if(x == root.val || y == root.val)
            {
                if(depth1 == -1)
                { depth1 = level;
                 parent1 = parent;
                }
                else
                {  depth2 = level;
                 parent2 = parent;
                }
             
                return ;
                
            }
        getDepth( root.right,  x,  y, level +1,root);
       
        
        return ;
    }
}