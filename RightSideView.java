// TimeComplexity: O(n)
// SpaceComplexity: O(W)
// Ran succesfully on Leetcode: yes
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        // initialize queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = q.size();

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            size--;
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
            // take new size snapshot of the queue and add right most val for the level
            if (size == 0) {
                size = q.size();
                list.add(curr.val);
            }
        }
        return list;

    }
}