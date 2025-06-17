// Time Complexity: O(n) Every node is visited once.
// Space Complexity: O(n) Worst-case: last level contains n/2 nodes ⇒ space in queue = O(n).

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
class BT_RightSideView_LC199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        viewFromRight(root, 0, result);
        
        return result;
    }

    private void viewFromRight(TreeNode root, int depth, List<Integer> result) {
        if (root == null) return;

        if (result.size() == depth)
            result.add(root.val);

        viewFromRight(root.right, depth + 1, result);
        viewFromRight(root.left, depth + 1, result);

    }

}