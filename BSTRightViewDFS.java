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
//tc= o(n)
//sc-o(h)
    
class Solution {
    List<Integer>result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
         dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int depth)
    {
        //base case
        if(root == null) return;
        //logic
        if(depth == result.size())
        {
            result.add(root.val);
        }
        else
        {
           result.set(depth,root.val); 
        }
        dfs(root.left, depth+1);
        dfs(root.right,depth+1);
        
        
    }
}