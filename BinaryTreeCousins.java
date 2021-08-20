/**
 * Definition for a binary tree node.
 */ 
 // Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :Nope


// Your code here along with comments explaining your approach
/*Approach
1) the catch is to find nodes which can be on same levels but having diferent parents
2) Imagine a family tree, same level indicates same/ similar age. above levels represent parents and grandfathers
3) For this, we can use a queue as we need level by level traversal
4) we use 2 variables which indicate whether the nodes are being found or not.
5) if they are found and belong to same parent we return false
6) 
*/


import java.util.*;

class BinaryTreeCousins {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {

        
       if(root==null)
           return false;
        
        
        Queue<TreeNode> queue = new LinkedList();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            boolean X_found=false;
            boolean Y_found= false;
        
            int level = queue.size();
            for(int i=0;i<level;i++)
            {
                TreeNode node = queue.poll();
                
                if(node.val==x)
                {
                    X_found=true;
                }
                
                if(node.val==y)
                {
                    Y_found=true;
                }
                
                if(node.left!=null && node.right!=null)
                {
                    // checking if values belong to same node
                    if(node.left.val==x && node.right.val==y) 
                    {
                        return false;
                    }
                    
                    if(node.left.val==y && node.right.val==x)
                    {
                        return false;
                    }
                }
                  
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
                
            }
            // when the above conditions fails, i.e they do not belong to same parent
            // we are confident and can return true
            if(X_found && Y_found)
            {
                return true;
            }
            
            if(X_found || Y_found)
            {
                return false;
            }
        }
        
        return false;
    }
}