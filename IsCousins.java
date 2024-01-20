/*
* Approach:
*  1. Applying DFS by comparing x and y with root.left and root.right
        along with level.
* 
*  2. after completion of dfs, check whether x and y parents 
        and their levels. 
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(h) === O(n)
    height of tree
* 
*/

public class IsCousins {
    int xLevel, yLevel;
    TreeNode xParent = null, yParent = null;

    private void dfs(TreeNode root, int x, int y, int level) {
        if (root == null)
            return;

        if (root.left != null) {
            if (root.left.val == x) {
                xParent = root;
                xLevel = level;
            }
            if (root.left.val == y) {
                yParent = root;
                yLevel = level;
            }
        }

        if (root.right != null) {
            if (root.right.val == x) {
                xParent = root;
                xLevel = level;
            }
            if (root.right.val == y) {
                yParent = root;
                yLevel = level;
            }
        }

        dfs(root.left, x, y, level + 1);
        dfs(root.right, x, y, level + 1);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y)
            return false;

        dfs(root, x, y, 0);

        return xParent != yParent && xLevel == yLevel;
    }
}
