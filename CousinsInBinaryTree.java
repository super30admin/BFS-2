import java.util.LinkedList;
import java.util.Queue;




public class CousinsInBinaryTree {
    // if nodes are at same level and their parents are different then they are
    // cousins
    TreeNode x_parent, y_parent;
    int x_depth, y_depth;
    // for optimization, we can have isXFound, isYFound, as soon as we found both we
    // can return
    boolean isXFound, isYFound;

    public boolean isCousins(TreeNode root, int x, int y) {
        /*
         * if(root.val==x||root.val==y)return false;
         * dfs(root,null,x,y,0);
         * return x_parent!=y_parent && x_depth==y_depth;
         */
        return bfs(root, x, y);
    }


    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : yes

    public boolean bfs(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        if (root.val == x || root.val == y)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isXFound = false;
            boolean isYFound = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == x)
                    isXFound = true;
                if (node.val == y)
                    isYFound = true;
                if (node.left != null & node.right != null) {
                    if (node.left.val == x && node.right.val == y)
                        return false;
                    if (node.left.val == y && node.right.val == x)
                        return false;
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
            if (isXFound && isYFound)
                return true;
            if (isXFound || isYFound)
                return false;
        }
        return false;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(h)
    // Did this code successfully run on Leetcode : yes

    public void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
        // base
        if (root == null)
            return;
        // stop the recursion when we find both the nodes
        if (isXFound && isYFound)
            return;

        // logic
        if (root.val == x) {
            x_parent = parent;
            x_depth = depth;
            isXFound = true;
        }
        if (root.val == y) {
            y_parent = parent;
            y_depth = depth;
            isYFound = true;
        }

        dfs(root.left, root, x, y, depth + 1);

        dfs(root.right, root, x, y, depth + 1);

    }

}