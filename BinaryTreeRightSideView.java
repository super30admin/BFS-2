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

// T.C - O(N) 
// S.C - O(h), h-height of the tree

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        
        dfs(root, 0);
        
        return result;
    }
    
    public void dfs(TreeNode root, int level){
        //base
        if(root == null) return;
        
        //logic
        if(result.size() == level) //level=1 & result.size=1(first root alone might have added, then add the new element)
            result.add(root.val);

        
        dfs(root.right, level+1);
        dfs(root.left, level+1);
        
    }
}
