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
 #time complexity : O(n)
 space complexity : O(log(n))
 */
class Solution {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        getRes(root,0);
               
        return res;
    }
    private void getRes(TreeNode root, int level){
        if(root == null) return;
        
        if(level == res.size())
            res.add(root.val);
        getRes(root.right,level +1);
        getRes(root.left,level +1);
    }
}
