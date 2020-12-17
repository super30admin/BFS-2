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
 Time complexity : O(N)
 Space Complexity : O(N)
 The Idea is to write recursion like the one in level order traversal but since we need right view
 we first traverse right side then left side. In other words i don't need to add any value after I read first 
 value in the level so this logic works. See logic of level order traversal to catch the similarity.
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root,result,0);
        return result;
    }
    
    public void helper(TreeNode root, List<Integer> result, int depth){
        if(root == null){
            return;
        }
        if(depth == result.size()){
            result.add(root.val);
        }
        helper(root.right,result,depth+1);
        helper(root.left,result,depth+1);
    }
}