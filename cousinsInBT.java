// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class cousinsInBT {
    int level;
    TreeNode curr;
    public boolean isCousins(TreeNode root, int x, int y) {
    level = -1;
    curr = null;

        return (dfs(root,0,x) == dfs(root,0,y) && (findParent(root,null,x) != findParent(root,null,y)));
    }

    private TreeNode findParent(TreeNode node, TreeNode p, int val) {
        if (node == null) {
            return null;
        }
        findParent(node.left, node, val);
        if (node.val == val) {
            curr = p;
        }
        findParent(node.right, node, val);
        return curr;
    }

    private int dfs(TreeNode node, int level, int val) {
        if (node == null) {
            return -1;
        }

        dfs(node.left,level+1,val);
        if (node.val == val) {
            this.level = level;
        }
        dfs(node.right,level+1,val);
        return this.level;
    }
}