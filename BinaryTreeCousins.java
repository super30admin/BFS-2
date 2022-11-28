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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] one = helper(root, x, 0);
        int[] two = helper(root, y, 0);
        if(one[0]==-1 || two[0]==-1){
            return false;
        }
        else if(one[0]!=two[0] && one[1]==two[1]){
            return true;
        }
        else{
            return false;
        }
    }
    public int[] helper(TreeNode root, int num, int depth){
        if(root==null){
            return new int[]{-1, -1};
        }
        if(root.left!=null && root.left.val==num){
            return new int[]{root.val, depth+1};
        }
        if(root.right!=null && root.right.val==num){
            return new int[]{root.val, depth+1};
        }
        if(helper(root.left, num, depth+1)[0]!=-1){
            return helper(root.left, num, depth+1);
        }
        else{
            return helper(root.right, num, depth+1);
        }
    }
}