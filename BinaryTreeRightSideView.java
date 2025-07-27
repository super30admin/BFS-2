// Time Complexity : O(n)
// Space Complexity : O(n) or max width of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : traverse through the tree using bfs while maintaining size of each level of queue i.e, each level
/// the last element in each level is the right side view of tree
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
        LinkedList<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        q.add(root);
        int size = 0;
        while(!q.isEmpty()){
            size = q.size();
            res.add(q.getLast().val);
            for(int i=0;i<size;i++){
                TreeNode curr = q.remove();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
}