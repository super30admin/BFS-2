## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

// Time Complexity - 0(n) because the method uses a depth-first search (DFS) traversal to visit each node exactly once.
// Space Complexity - 0(h) because the space usage is determined by the maximum depth of the recursion stack during the DFS traversal.

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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        dfs(root, 0);
        return result;       
    }
    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}


## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

// Time Complexity - 0(n) because the method performs a breadth-first search (BFS) traversal of the tree, visiting each node once.
// Space Complexity - 0(m) because in the BFS traversal, the queue (q) can store up to m nodes at the maximum level.

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
        if (root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                if (curr.val == x) {
                    x_found = true;
                }
                if (curr.val == y) {
                    y_found = true;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (x_found == true && y_found == true) {
                return true;
            }
            if (x_found == true || y_found == true) {
                return false;
            }
        }
        return true;
    }
}