// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class RightSideView {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return res;
        // dfs approach
        // dfs(root, 0);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0)
                    res.add(node.val);

                if (node.right != null)
                    q.offer(node.right);
                if (node.left != null)
                    q.offer(node.left);
            }
        }

        return res;
    }
}