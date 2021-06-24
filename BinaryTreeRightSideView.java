// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

/**
 * We have applied DFS approach to recurse the right child before the left child.
 * if the level of any node is equal to the size of the result list, we addd that element to the result.
 * In tghis way, we make sure that right element of each level is inserted in the result.
 */


class Solution {
    
    // Recursive DFS solution
    // Postorder --> Process Right child first
    
    List<Integer> res;
    
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        
        dfs(root, 0);
        
        return res;
    }
    
    private void dfs(TreeNode root, int level) {
        if(level == res.size()) {
            res.add(root.val);
        }
        
        if(root.right != null) {
            dfs(root.right, level+1);
        }
        if(root.left != null) {
            dfs(root.left, level+1);
        }
    }
}
