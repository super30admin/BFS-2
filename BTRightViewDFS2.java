//Time Complexity = O(N), where N is the number of nodes
//Space Complexity = O(H), where H is the height of the tree
//Did it run successfully on Leetcode: Yes

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
        if (root == null) return new ArrayList<Integer>();

        result = new ArrayList<Integer>();

//       DFS
        dfs(root, 0);
        return result;
    }

    void dfs(TreeNode root, int level) {
        if(root == null) return;

        if(level == result.size()) result.add(root.val);
        else result.set(level, root.val);

        dfs(root.left, level+1);
        dfs(root.right, level+1);

    }
}