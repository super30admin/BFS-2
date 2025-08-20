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
 // This solution completes the level order tranversal and capture the first element in each level into a list. We iteratively add the right node to capture the first element. Alternatively this can be done with recurive approach and also adding left element first
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightViewList = new ArrayList();
        if(root==null) return rightViewList;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(i==0) {
                    rightViewList.add(node.val);
                }
                if(node.right!=null) queue.add(node.right);
                if(node.left!=null) queue.add(node.left);
            }
        }
        return rightViewList;
    }
}
