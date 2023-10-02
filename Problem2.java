//TimeComplexity  : O(n)
//Space Complexity : O(h) being stack space
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

public class Problem2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode xParent, yParent;
    int x_lvl, y_lvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        x_lvl =-1;
        y_lvl = -1;
        dfs(root,x,y,0,null);
        return (x_lvl == y_lvl) &&(xParent != yParent);
    }

    private void dfs(TreeNode root,int x, int y, int lvl, TreeNode parent){
        if(root == null || (x_lvl != -1 && y_lvl !=-1) ){
            return;
        }
        if(root.val == x ){
            xParent = parent;
            x_lvl = lvl;
        }
        if(root.val == y){
            yParent = parent;
            y_lvl = lvl;
        }
        dfs(root.left,x,y,lvl+1,root);
        dfs(root.right,x,y,lvl+1,root);
    }
}
