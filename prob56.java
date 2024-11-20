//Time Complexity-O[N]
//Space Complexity-O[1]
//Ran successfully on leetcode
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
    //vars to store depth and parent of x and y 
    int xdepth;
    int xparent;
    int ydepth;
    int yparent;

    public boolean isCousins(TreeNode root, int x, int y) {
        traverse(null, root, 0, x, y);

        return xdepth != 0 && ydepth != 0 && xdepth == ydepth && xparent != yparent;
    }

    public void traverse(TreeNode parent, TreeNode node, int depth, int x, int y) {
        if (node == null)
            return;

        if (node.val == x) {
            xdepth = depth;
            if(parent==null) xparent=0;
            else xparent = parent.val;
        }
        if (node.val == y) {
            ydepth = depth;
            if(parent==null) yparent=0;
            else yparent = parent.val;
        }

        traverse(node, node.left, depth + 1, x, y);
        traverse(node, node.right, depth + 1, x, y);
    }
}