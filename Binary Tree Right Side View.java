/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode rMostNode = null;

            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                rMostNode = node;

                if(node.left != null) queue.add(node.left);
                
                if(node.right != null) queue.add(node.right);
            }
            result.add(rMostNode.val);
        }
        return result;
    }
}

// Time Complexity: O(N) -> Each node is visited once.
// Space Complexity: O(N) -> Queue stores at most N/2 nodes at the last level in the worst case.
