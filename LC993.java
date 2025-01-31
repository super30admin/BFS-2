// TC: O(n)
// SC: O(n)
// where n is the number of nodes in the tree

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
}

public class LC993 {
    int d1, p1, d2, p2;
    private void dfs(TreeNode root, int x, int y, int depth, int par){
        if(root==null) return;
        if(root.val==x) {
            this.d1 = depth;
            this.p1 = par;
        }
        if(root.val == y) {
            this.d2 = depth;
            this.p2 = par;
        }
        dfs(root.left, x, y, depth+1, root.val);
        dfs(root.right, x, y, depth+1, root.val);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, 0);
        return (d1==d2 && p1!=p2);
    }
}
