/**
 * Approach: DFS (Depth-First Search) with Sibling Check
 *
 * This solution uses DFS to find the depth of both target nodes x and y, and checks if they are siblings (share the same parent).
 * If x and y are at the same depth but are not siblings, they are cousins.
 *
 * Time Complexity: O(N), where N is the number of nodes in the tree.
 * Space Complexity: O(H), where H is the height of the tree (due to recursion stack).
 */

public class CousinsInBinaryTree2 {

    int xDepth;
    int yDepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        boolean flag = findX(root, x, y, 0, root);
        if (!flag)
            return false;
        return xDepth == yDepth;
    }

    private boolean findX(TreeNode node, int x, int y, int depth, TreeNode parent) {
        //base
        if (node == null)
            return true;

        if (node.left != null && node.right != null) {
            if (node.left.val == x && node.right.val == y)
                return false;
            if (node.left.val == y && node.right.val == x)
                return false;
        }
        if (node.val == x) {
            xDepth = depth;
        }
        if (node.val == y) {
            yDepth = depth;
        }
        return findX(node.left, x, y, depth + 1, node) && findX(node.right, x, y, depth + 1, node);
    }
}
