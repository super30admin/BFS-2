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
        Queue<TreeNode> q = new LinkedList<>();

        if(root != null) q.offer(root);

        while(!q.isEmpty()){
            Integer num = null;
            int qSize = q.size();

            while(qSize-- > 0){
                TreeNode node = q.poll();
                if(num == null) num = node.val;
                if(node.right != null) q.offer(node.right);
                if(node.left != null) q.offer(node.left);
            }

            result.add(num);
        }

        return result;
    }
}
