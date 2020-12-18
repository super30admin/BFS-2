/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsCousins(TreeNode root, int x, int y) {
        int heightofx=0;
        int heightofy =0;
        
        Queue<TreeNode> q = new Queue<TreeNode>();
        q.Enqueue(root);
        
        while(q.Count >0)
        {
                bool siblings = false;
                bool cousins = false;
​
                int depthofnode = q.Count;
            
            for(int i=0;i<depthofnode;i++)
            {
                TreeNode tn = q.Dequeue();
                if(tn==null)
                {
                    siblings = false;
                }
                else
                {
                    if(tn.val==x || tn.val ==y)
                    {
                        if(!cousins)
                        {
                            siblings = cousins = true;
                        }
                        else
                        {
                            return !siblings;
                        }
                    }
                
                
                if(tn.left!=null) {
                    q.Enqueue(tn.left);
                }
                if(tn.right!=null) {
                    q.Enqueue(tn.right);
                }
                q.Enqueue(null);
                
            }
            
            
        }
        if(cousins) return false;
    }
        return false;
    }
        
    }
​
