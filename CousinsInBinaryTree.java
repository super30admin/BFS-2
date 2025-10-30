/**
 * Leet Code : https://leetcode.com/problems/cousins-in-binary-tree/description/
 * Approach: DFS (Depth-First Search)
 *
 * This solution traverses the binary tree using DFS to find the depth and parent of both target nodes x and y.
 * After traversal, it checks if x and y are at the same depth but have different parents, which means they are cousins.
 *
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(H), where H is the height of the tree (due to recursion stack).
 */

public class CousinsInBinaryTree {
    int xDepth;
    TreeNode xParent;

    int yDepth;
    TreeNode yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        findX(root, x, y, 0, root);
        return xParent != yParent && xDepth == yDepth;
    }

    private void findX(TreeNode node, int x, int y, int depth, TreeNode parent) {
        //base
        if (node == null) return;

        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        }
        if (node.val == y) {
            yDepth = depth ;
            yParent = parent;
        }
        findX(node.left, x, y, depth + 1, node);
        findX(node.right, x, y, depth + 1, node);
    }
}
