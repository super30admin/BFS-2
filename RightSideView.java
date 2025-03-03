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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        rightView(root,output,0);
        return output;
    }
    public void rightView(TreeNode curr,List<Integer> output,int currDepth){
        if(curr == null)
            return;
        if(currDepth == output.size()){
            output.add(curr.val);
        }
        rightView(curr.right,output,currDepth+1);
        rightView(curr.left,output,currDepth+1);
    }
    
}