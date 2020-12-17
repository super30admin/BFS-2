// Time Complexity :O(N)
// Space Complexity :O(H) where h is the height of the tree 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach:First start traversing from the right node of the root and continure dfs;
// If the result arraylist size is same as the level , then it is the first node we are traversing at that level. So add it to arraylist.
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
    List<Integer> result= new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
        return result;
        
        helper(root,0);
        return result;
    }
    public void helper(TreeNode root, int level){
        if(root==null)
            return;
        if(result.size()==level)
            result.add(root.val);
        helper(root.right,level+1);
        helper(root.left,level+1);
            
    }
}