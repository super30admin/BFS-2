
//#TimeComplexity:O(N)
//#SpaceComplexity: O(max diameter of tree)
//#Did this code successfully run on Leetcode : Yes
//#Any problem you faced while coding this : No
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

        List<Integer> result = new LinkedList<>();

        if(root==null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int N = queue.size();
            for(int i=0;i<N;i++){ //level order traversal
                TreeNode current = queue.poll();
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
                if(i==N-1){
                    result.add(current.val); //add last node to result
                }
            }
        }

        return result;
    }
}