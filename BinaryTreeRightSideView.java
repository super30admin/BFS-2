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
//Time complexity is O(N)
//Space complexity is O(N)
class Solution {
    List<Integer> result=new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 1);
        
        return result;
    }
    public void helper(TreeNode root, int len){
        if(root==null){
            return;
        }
        if(result.size()<len){
            result.add(root.val);
        }
        else{
            result.set(len-1, root.val);
        }
        helper(root.left, len+1);
        helper(root.right,len+1);

    }

}