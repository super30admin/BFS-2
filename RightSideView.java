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
    List<Integer> l = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) { 
        if(root == null)
            return l;
        List<TreeNode> child = new ArrayList<>();
        child.add(root);
        l.add(root.val);
        helper(child);
        return l;
    }
    public void helper(List<TreeNode> child){
        List<TreeNode> res1 = new ArrayList<>();
        for(int i=0;i<child.size(); i++){
            if(child.get(i).left!=null){
                res1.add(child.get(i).left);
            }
            if(child.get(i).right!=null){
                res1.add(child.get(i).right);
            }
        }
        if(res1.size()==0)
            return;
        l.add(res1.get(res1.size()-1).val);
        helper(res1);
    }
}

//Time complexity - O(n) where n is the number of nodes in binary tree
//space complexity - O(H) where H is the height of binary tree
