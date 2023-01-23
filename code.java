// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int depth){
        if(root == null) return;
        if(result.size() == depth){
            result.add(root.val);
        }else{
            result.set(depth, root.val);
        }
            dfs(root.left, depth+1);
            dfs(root.right, depth+1);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    TreeNode ParentX;
    int depthX;
    TreeNode ParentY;
    int depthY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root,x,y,0, null);
        return depthX == depthY && ParentX != ParentY;
    }
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null) return;
        if(root.val == x){
            depthX = depth;
            ParentX = parent;
        }
        if(root.val == y){
            depthY = depth;
            ParentY = parent;
        }
        dfs(root.left, x, y, depth+1, root);
        dfs(root.right, x, y, depth+1, root);
    }
}

