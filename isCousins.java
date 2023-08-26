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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        while (!nodesQueue.isEmpty()) {
            int levelSize = nodesQueue.size();
            boolean isXFound = false;
            boolean isYFound = false;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodesQueue.poll();
                if (currentNode.val == x) isXFound = true;
                if (currentNode.val == y) isYFound = true;

                // Checking if the two nodes are siblings
                if (currentNode.left != null && currentNode.right != null) {
                    if (currentNode.left.val == x && currentNode.right.val == y) return false;
                    if (currentNode.left.val == y && currentNode.right.val == x) return false;
                }

                if (currentNode.left != null) nodesQueue.add(currentNode.left);
                if (currentNode.right != null) nodesQueue.add(currentNode.right);
            }

            if (isXFound && isYFound) return true;
        }
        return false;
    }
}
