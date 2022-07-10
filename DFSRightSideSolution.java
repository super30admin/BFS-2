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
class DFSRightSideSolution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        
        int level = 0;
        //base
        if (root == null) return result;
        //logic DFS Solution
        dfs(root,level);        
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        
            if (root == null) return;
            if (result.size() == level) {
                result.add(root.val);
            } else {
                result.set(level,root.val);
            }
            
            dfs(root.left,level+1);
            dfs(root.right,level+1);
            
        }
}