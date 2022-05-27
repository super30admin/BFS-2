import java.util.*;

class Solution {
    // DFS Left side view solution with right recursive call first
    // Time complexity is O(n)
    // Space complexity is O(h)
    // This solution is submitted on leetcode with zero errors
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
    private List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        //egde case
        if(root == null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        // base case
        if(root==null) return;
        //logic
        if(level== result.size()){
            result.add(root.val);
        } else {
            result.set(level,root.val); // over riding the value
        }
        //doing right recursive call first
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}