//TC: O(n)
//SC: O(1)
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

//DFS:
class CousinInBinaryTree {
    int xHt = 0; int yHt = 0;
    TreeNode xParent; TreeNode yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        if(xParent != yParent && xHt == yHt) {
            return true;
        }
        else return false;
    }
    private void dfs(TreeNode root, TreeNode parent, int ht, int x, int y) {
        if(root == null) return;
        if(root.val == x) {
            xParent =parent;
            xHt= ht;
        }
        if(root.val == y) {
            yParent =parent;
            yHt= ht;
        }
        dfs(root.left, root, ht+1, x, y);
        dfs(root.right, root, ht+1, x, y);
    }
}

//BFS:

