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
    boolean x_found;
    boolean y_found;
    int x_parent;
    int y_parent;
    int x_depth;
    int y_depth;
    int parent;
    

    public boolean isCousins(TreeNode root, int x, int y) {
        int depth;
        int parent;
        if (root == null)
            return false;

        dfs(root, 0, x, y,0);

        if (x_found == true && y_found == true) {
            if ((x_depth == y_depth) && (x_parent != y_parent)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    private void dfs(TreeNode root, int depth, int x, int y,int parent) {
        if (root == null) return;

        if (root.val == x || root.val == y) {
            if (root.val == x) {
                x_found = true;
                x_parent = parent;
                x_depth = depth;
            }

            if (root.val == y) {
                y_found = true;
                y_parent = parent;
                y_depth = depth;
            }

        }
        parent = root.val;

        dfs(root.left, depth + 1, x, y,parent);
        dfs(root.right, depth + 1, x, y,parent);
    }
}




/**

TC : O(n)
Sc : O(n)

Description : In DFS, Checking children at every node and retuning false if both x & y belongs to one parent. if not then checking at level, if we find x & y in same level then returing true;





 */