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

//Space Complexity=O(n)
//Time complexity=O(n)
//WE are using BFS in this method to solve our problem
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode leftn,rightn;
        while(!q.isEmpty())
        {
            int size=q.size();
            boolean xfound=false,yfound=false;
            for(int i=0;i<size;i++)
            {
                
                TreeNode curr=q.poll();
                if(curr.val==x) xfound=true;
                if(curr.val==y) yfound=true;
                if(curr.left!=null && curr.right!=null) 
                {
                    leftn=curr.left;
                    rightn=curr.right;
                    if(leftn.val==x && rightn.val==y || leftn.val==y && rightn.val==x) return false;
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(xfound && yfound) return true;
        }
        return false;
        
    }
}