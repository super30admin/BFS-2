//Time Complexity - O[N]
//Space Complexity - O[1]


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Storing the parent values and the depths of the given x and y in variables
    int xdepth;
    int xparent;
    int ydepth;
    int yparent;

    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(null, root, 0, x, y);

        #Checking if the depths of x and y are equal and the parent of x and y are not the same
        return xdepth != 0 && ydepth != 0 && xdepth == ydepth && xparent != yparent;
    }

    //Traversing through the entire tree and increasing the depth by 1 for each traversal
    public void traverse(TreeNode parent, TreeNode node, int depth, int x, int y) {
        if (node == null)
            return;

        if (node.val == x) {
            xdepth = depth;
            xparent = parent == null? 0: parent.val;
        }
        if (node.val == y) {
            ydepth = depth;
            yparent = parent == null? 0: parent.val;
        }

        traverse(node, node.left, depth + 1, x, y);
        traverse(node, node.right, depth + 1, x, y);
    }
}