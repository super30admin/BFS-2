/**
 * @author Vishal Puri
 * // Time Complexity : O(n)
 * // Space Complexity : O(h)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class IsCousins {
    int prex = 0, prey = 0, levelx = 0, levely = 0;
    boolean res = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        int level = 0;
        DFS(root, x, y, level, -1);
        return res;
    }

    void DFS(TreeNode root, int x, int y, int level, int parent) {
        if (root == null) return;
        if (root.val == x) {
            prex = parent;
            levelx = level;
        }
        if (root.val == y) {
            prey = parent;
            levely = level;
        }

        level++;

        if (prex != prey && prex != 0 && prey != 0 && levelx == levely) {
            res = true;
            return;
        }
        DFS(root.left, x, y, level, root.val);
        DFS(root.right, x, y, level, root.val);
    }
}
