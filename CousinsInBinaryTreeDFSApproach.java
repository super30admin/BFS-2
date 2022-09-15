// Time complexity: O(N)
// Space complexity: O(H)

// Approach: we take 4 global variables, xdepth, ydepth, xparent, and yparent. Then we perform a dfs with 2 local variables, depth and parent. basically we keep visiting nodes until we find x and y in our tree. Once we find x or y, we store their parent and depth local variables in our global variables. In the end after dfs is done (after we have found our x and y), we check if x and y have different parents and if they are on the same depth (level) then that means they are cousins, else they are not.

class Solution {
    TreeNode xParent; TreeNode yParent;
    int xDepth; int yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        dfs(root, x, y, 0, null);
        return xParent != yParent && xDepth == yDepth;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        // base
        if (root == null) return;
        
        // logic
        if (root.val == x) {
            xParent = parent;
            xDepth = depth;
        }
        if (root.val == y) {
            yParent = parent;
            yDepth = depth;
        }
        if (xParent == null || yParent == null) dfs(root.left, x, y, depth+1, root); // adding the if condition for optimization. Basically if we found our xParent and yParent, we don't need to continue recursion and can break out
        if (xParent == null || yParent == null) dfs(root.right, x, y, depth+1, root); // adding the if condition for optimization. Basically if we found our xParent and yParent, we don't need to continue recursion and can break out
    }
}