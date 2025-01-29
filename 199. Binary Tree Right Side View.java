/**
 * # Time complexity: O(n), where n is the number of nodes in the tree, as each node is visited once.
 * # Space complexity: O(n), due to the queue used for level-order traversal in the worst case.
 * # Leetcode: Yes
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();

        if (root == null) return arr;
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (i == size - 1) {
                    arr.add(curr.val);
                }
                if (curr.left != null) que.add(curr.left);
                if (curr.right != null) que.add(curr.right);
            }
        }
        return arr;
    }
}
