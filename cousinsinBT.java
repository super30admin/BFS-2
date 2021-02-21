// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null)
            return false;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<TreeNode, Integer>(root, -1));

        while (!q.isEmpty()) {
            int size = q.size();

            int px = -1, py = -1;

            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> p = q.poll();

                TreeNode node = p.getKey();
                int parent = p.getValue();

                if (node.val == x) {
                    px = parent;
                }
                if (node.val == y) {
                    py = parent;
                }

                if (node.left != null)
                    q.add(new Pair<TreeNode, Integer>(node.left, node.val));
                if (node.right != null)
                    q.add(new Pair<TreeNode, Integer>(node.right, node.val));

            }
            if (px != -1 && py != -1 && px != py)
                return true;

        }

        return false;

    }
}