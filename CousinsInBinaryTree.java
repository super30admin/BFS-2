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
 // This uses a DFS approach of recursing through all the nodes and spotting for x and y. If at all its spotted we capture the elements in the global like parent and height. At the end, we compare both as per the needs.
class Solution {
    int x_height = -1, y_height = -1;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        fetchNodes(root, x, y, null, 0);
        if(x_parent==null || y_parent==null) return false;

        return (x_height==y_height) && (x_parent!=y_parent);
    }
    
    private void fetchNodes(TreeNode root, int x, int y, TreeNode parent, int height) {
        if(root==null) return;

        if(x==root.val) {
            x_height = height;
            x_parent = parent;
            return;
        }

         if(y==root.val) {
            y_height = height;
            y_parent = parent;
            return;
        }

        if(root.left!=null) {
            fetchNodes(root.left, x, y, root, height+1);
        }

        if(root.right!=null) {
            fetchNodes(root.right, x, y, root, height+1);
        }
    }
}
