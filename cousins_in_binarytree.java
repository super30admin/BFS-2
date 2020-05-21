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
DFS Solution
Time Complexity: O(N)
Space Complexity: O(h) where h is the height of the tree;
 
 class Solution {
    int x_depth, y_depth;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        dfs(root, x, y, 0, null);
        return x_depth == y_depth && x_parent != y_parent;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent)
    {
        //base case
        
        if(root == null) return;
        
        //logic
        if(root.val == x){
            x_depth = depth; x_parent = parent;
        }
        if(root.val == y){
            y_depth = depth; y_parent = parent;
        }
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}
 */

/*
BFS Solution:

*/
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            boolean siblings = false;
            boolean cousins = false;
            
            int size = q.size();
            
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                
                if(curr == null)
                {
                    siblings = false;
                }
                else
                {
                    if(curr.val == x || curr.val == y)
                    {
                        if(!cousins)
                            siblings = cousins = true;
                        else
                            return !siblings;
                    }
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                q.add(null);
                }
                
            }
            if(cousins) return false;
        }
        return false;
    }
}