//TC - O(N) 
//SC - O(h) recursive stack space
/*
I stored xParent, yParent and xDepth and yDepth by traversing in DFS way
At the end, when dfs is completed I used condition to determine if they are cousins
*/

import javax.swing.tree.TreeNode;

public class Problem2 {
    int xDepth;
    int yDepth;
    TreeNode xParent;
    TreeNode yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        xParent = null;
        yParent = null;
        dfs(root, x, y, null, 0);
        if(xParent != null && yParent != null) {
            if(xParent == yParent) {
                return false;
            } else if(xDepth != yDepth) {
                return false;
            }
        }

        if(xParent == null || yParent == null) {
            return false;
        }

        return true;
    }

    private void dfs(TreeNode root, int x, int y, TreeNode parent, int depth) {
        //base 
        if(root == null) {
            return;
        }

        //logic
        if(root.val == x) {
            xParent = parent;
            xDepth = depth;
        }

        if(root.val == y) {
            yParent = parent;
            yDepth = depth;
        }

        dfs(root.left,x,y,root, depth+1);
        dfs(root.right, x, y, root, depth+1);
    }
}
