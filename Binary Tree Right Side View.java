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
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        DFS(root, 0);
        return result;
    }

    void DFS(TreeNode root, int level)
    {
        //base condition
        if(root == null) return;

        //logic
        if(result.size() == level)
        {
            result.add(root.val);
        }
        else
        {
            result.set(level, root.val);
        }
        DFS(root.left, level + 1);
        DFS(root.right, level + 1);
    }
}