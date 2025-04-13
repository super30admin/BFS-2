//199. Binary Tree Right Side View
//Time Complexity: O(n)
//Space Complexity: O(n)

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
       List<Integer> result = new ArrayList<>();
       view(root,result,0);
       return result;
    }
    public void view(TreeNode root, List result, int depth){
        if(root == null) return;

        if(depth==result.size())
           result.add(root.val);

       view(root.right,result,depth+1);
       view(root.left,result,depth+1);
    }
}