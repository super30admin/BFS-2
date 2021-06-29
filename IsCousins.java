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
// Time Complexity: O(n).. since we are traversing each node in the tree in the worst case
//Space Compelxity: O(n).. since we are using a queue and in the worst case O(n) space is required
//Leetcode: 993. Cousins in Binary Tree

// Using BFS

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        //if root is x then y can't be its sibling and viceversa
        if(root.val==x || root.val==y)
        {
            return false;
        }
        TreeNode xparent=null, yparent=null;
        int xlevel=-1,ylevel=-1;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int len=0;
        TreeNode node;
        TreeNode left;
        TreeNode right;
        int level=0;
        boolean xfound=false, yfound=false;
        
        while(!q.isEmpty())
        {
            len=q.size();
            level++;
            
            // process the nodes by level
            for(int i=0;i<len;i++)
            {
                node=q.poll();
                left=node.left;
                right=node.right;
                
                if(left!=null)
                {
                    if(left.val==x)
                    {
                        xlevel=level;
                        xparent=node;
                        xfound=true;
                    }
                    else if(left.val==y)
                    {
                        ylevel=level;
                        yparent=node;
                        yfound=true;
                    }
                    q.add(left);
                }
                if(right!=null)
                {
                    if(right.val==x)
                    {
                       xlevel=level;
                       xparent=node;
                        xfound=true;
                    }
                    else if(right.val==y)
                    {
                        ylevel=level;
                        yparent=node;
                        yfound=true;
                    }
                    q.add(right);
                }
                
                
            }
            
            // After each level check if x and y are found
            if(xfound && yfound)
            {
                return xlevel==ylevel && (xparent!=yparent);
            }
            
            
        }
        
            
        
        return false;
    }
}