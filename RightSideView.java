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



//Time Complexity: O(n) ..Because we are traversing all the nodes
// Space Complexity: O(n)..Because we are using a queue and in worst case , since it is a binary tree,  max elements stored would be in the order of n/2(esp for a complete binary tree)
// Leetcode: 199. Binary Tree Right Side View
// Using BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int len=0;
        TreeNode node;
        while(!q.isEmpty())
        {
            len=q.size();
            
            
            for(int i=0;i< len;i++)
            {
                node=q.poll();
                
                if(i==len-1)
                    list.add(node.val);
                
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
            
        }
        
        return list;
    }
}
/*
//Time Complexity: O(n) ..Because we are traversing all the nodes
// Space Complexity: O(n)...for recursive stack, space would be O(height of tree)..in the worst case if the tree is linear, it would be O(n)
// Using DFS
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        int level=0;
        dfs(root,0);
        
        return res;
        
    }
    
    
    private void dfs(TreeNode root, int level)
    {
        if(root==null)
            return;
        
        if(res.size()==level)
        {
           
            res.add(root.val);
        }
        else
        {
            res.set(level,root.val);
        }
            
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        
        
    }
}
*/