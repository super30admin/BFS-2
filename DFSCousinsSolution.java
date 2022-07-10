/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class DFSCousinsSolution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_level=0;
    int y_level=0;
    public boolean isCousins(TreeNode root, int x, int y) {       
        TreeNode parent = null;
        int level = 1;
        dfs(root, parent, level, x, y);
        return (x_parent != y_parent && x_level == y_level);        
    }
    
    private void dfs(TreeNode root, TreeNode parent,int level, int x, int y) {
        if (root == null) return;
        
        if (root.val == x){
            x_parent=parent;
            x_level=level;
            System.out.println("x_level=="+x_level);
        }
        if (root.val == y){
            y_parent=parent;
            y_level=level;
            System.out.println("y_level=="+y_level);
        }
        dfs(root.left, root,level+1,x, y);
        dfs(root.right, root,level+1,x, y);
        
        
    }
}