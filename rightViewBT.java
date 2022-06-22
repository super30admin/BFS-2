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
    //Time complexity: O(n)
    //Space complexity: O(h),h-height of the tree
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res=new ArrayList<>();
        if(root==null)
            return res;
        dfs(root,0);
        return res;
    }
    private void dfs(TreeNode root,int level){
        if(root==null)
            return;
        if(level==res.size()){
            res.add(root.val);
        }
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}