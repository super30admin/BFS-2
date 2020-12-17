public class ex61 {
    
 // Definition for a binary tree node.
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
 
class Solution {
    int xLevel, yLevel;
    TreeNode xParent, yParent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return true;
        dfs(root, null, 0, x, y);
        return xLevel == yLevel && xParent!= yParent;
    }
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root == null)
            return;
        if(root.val == x){
            xLevel= level;
            xParent = parent;
        }
        if(root.val == y){
            yLevel= level;
            yParent = parent;
        }
        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
        
    }
}
}
