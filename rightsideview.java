// TC : O(n)
// TC : O(H)

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
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        result = new ArrayList<>();
        
        dfs(root,0);
        
        return result;
    }
    
    private void dfs(TreeNode root, int lvl){
        
        if(root == null) return;
        
        if(lvl == result.size()){
            result.add(root.val);
        }
        dfs(root.right,lvl+1);
        dfs(root.left, lvl+1);
    }
}