// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

/*
 * DFS method: store the level and parent at each node,
 * if the node's val = x's val or y's val,
 * update the respective level (l) value and parent (p) value
 * finally check that lX = lY and pX != pY
 */
public class CousinsInBinaryTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    int levelX, levelY;
    TreeNode parentX, parentY;
    int x, y;

    void findLevel(TreeNode node, TreeNode parent, int level) {
        if (node == null) return;

        // record the values of the parents and the levels
        if (node.val == x) {
            levelX = level;
            parentX = parent;
        }
        if (node.val == y) {
            levelY = level;
            parentY = parent;
        }

        // go to the left and right nodes,
        // passing the parent and an incremented level
        findLevel(node.left, node, level + 1);
        findLevel(node.right, node, level + 1);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        findLevel(root, null, 0);
        // cousins have same level but different parents
        return levelX == levelY && parentX != parentY;
    }
}

