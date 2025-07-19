// Time Complexity: O(n)
// Space Complexity: O(H)

// We traverse the tree DFS and first we look at right side. If it is the first element at that level, we add to result. 

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
        if (root == null) return new ArrayList<>();
        rsvHelper(root, 0);
        return result;
    }

    public void rsvHelper(TreeNode root, int lvl) {
        if (root == null) return;

        if (result.size() == lvl) {
            result.add(root.val);
        }

        rsvHelper(root.right, lvl + 1);
        rsvHelper(root.left, lvl + 1);
    }
}
