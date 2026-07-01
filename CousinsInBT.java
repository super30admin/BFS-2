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
    /*
        TC - O(n)
        SC - O(h), where h is the tree height (O(log n) for a balanced tree and O(n) in the worst case).
        This solution uses DFS to determine whether two nodes are cousins.
        Starting from the root, it traverses the tree while keeping track of the depth (height) of each node.
        When either target node (x or y) is found, its depth is recorded.
        At each node, it also checks whether x and y are the left and right children of the same parent. 
        If they are, they have same parents, not cousins, so flag is set to false.
        After the traversal: If flag is false, the nodes are have same parents, so the answer is false.
        Otherwise, the nodes are cousins only if they are at the same depth.
    */
    int xHeight;
    int yHeight;
    boolean flag;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.flag = true;
        helper(root, 0, x, y);
        if (!flag) return false;
        return (xHeight == yHeight);
    }

    private void helper(TreeNode root, int height, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            xHeight = height;
        }

        if (root.val == y) {
            yHeight = height;
        }

        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y) flag = false;
            if (root.left.val == y && root.right.val == x) flag = false;
        }

        helper(root.left, height + 1, x, y);
        helper(root.right, height + 1, x, y);
    }
}