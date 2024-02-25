// Time Complexity :O(n)
// Space Complexity :O()
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:



class Solution {
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if( root ==  null) return false;
        dfs(root,null,0,x,y);
        return x_parent != y_parent && x_depth == y_depth;
    }
    public void dfs(TreeNode root, TreeNode parent, int depth, int x, int y){
        if(root == null) return;
        if(root.val == x){
            x_parent = parent;
            x_depth = depth;
        }
        if(root.val == y){
            y_parent = parent;
            y_depth = depth;
        }
        dfs(root.left, root, depth+1,x,y);
        dfs(root.right, root, depth+1,x,y);
    }
}