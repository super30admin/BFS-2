// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
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
        result = new ArrayList<Integer>();
        if(root == null)
            return result;
        helper(root, 0);
        return result;   
    }
    
    //traversing left-root-right
    private void helper(TreeNode root, int level){
        //base
        if(root == null) return;
        //logic
        if(result.size() == level)
            result.add(root.val); //new level 
        else
            result.set(level, root.val);//found new RightMost node at that level
        
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}