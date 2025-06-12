// Time complexity - O(n)
// Space complexity - O(n)
//Did you face any issues - No
// solved on leetcode- yes
// Initially creating a list and at every row we are adding the last element
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Add the rightmost element of each level
                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return result;
    }
}
