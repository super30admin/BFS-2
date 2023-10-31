// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BTCousins {
    boolean isCousins = true;
    int xLevel = 0, yLevel = 0;
    public boolean isCousins(TreeNode root, int x, int y)
    {
        dfs(root, 0, x, y);
        return isCousins && (xLevel == yLevel);
    }

    void dfs(TreeNode root, int level, int x, int y)
    {
        //base
        if(root == null)
            return;
        if(root.left != null && root.right != null &&
                ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)))
        {
            isCousins = false;
            return;
        }
        if(root.val == x)
            xLevel = level;
        if(root.val == y)
            yLevel = level;

        if(isCousins)
            dfs(root.left, level+1, x,y);
        if(isCousins)
            dfs(root.right, level+1, x,y);
    }
}
