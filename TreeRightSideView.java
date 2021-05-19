/*
Runtime complexity - O(N) where N is the number of nodes in a tree;
Space Complexity - O(H) where H is the height of the tree (we are not considering the output array size here)
*/

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
        result=new ArrayList<Integer>();
        getright(root,0);
        return result;
    }
    public void getright(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(result.size()==level)
            result.add(root.val);
        if(root.right!=null)
            getright(root.right,level+1);
        if(root.left!=null)
            getright(root.left,level+1);
        return;
    }
}