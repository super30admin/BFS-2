//https://leetcode.com/problems/binary-tree-right-side-view/

// Time Complexity :O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList<Integer>();
        if(root==null)
            return result;
        // inorderleft(root,0);
        bfs(root);
        return result;
        
    }
    //dfs approach with right recursive calls if the left calls happen the size of result will exceed
    private void inorder(TreeNode root,int level)
    {
        if(root==null) return;
        if(result.size()==level)  // add the value first and then traverse
            result.add(root.val);
        inorder(root.right,level+1);
        inorder(root.left,level+1);
    }
    //dfs with left recursive calls
    private void inorderleft(TreeNode root,int level)
    {
        if(root==null) return;
        if(result.size()==level)  // add the value first and then traverse
            result.add(root.val);
        else
            result.set(level,root.val);
        
        inorderleft(root.left,level+1);
       
        inorderleft(root.right,level+1);
    }
    //bfs 
    private void bfs(TreeNode root)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(i==size-1)
                    result.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                
            }
        }
    }
    
}