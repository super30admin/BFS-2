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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode parentX = null, parentY = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                    if (node.left.val == x)
                        parentX = node;
                    if (node.left.val == y)
                        parentY = node;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    if (node.right.val == x)
                        parentX = node;
                    if (node.right.val == y)
                        parentY = node;
                }
            }
            if(parentX != null && parentY != null){
                return parentX != parentY;
            }

            if(parentX != null || parentY != null){
                return false;
            }
        }
        return false;
    }
}

// Time Complexity: O(N) -> Each node is visited once in BFS/DFS.
// Space Complexity: O(N) -> Queue (BFS) or recursion stack (DFS) stores at most N nodes in the worst case.
