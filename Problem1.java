// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Problem1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        view(root, result, 0);
        return result;
    }
    public void view(TreeNode root, List result, int depth) {
        if (root == null)
            return;
        if (depth == result.size())
            result.add(root.val);
        view(root.right, result, depth + 1);
        view(root.left, result, depth + 1);
    }
}
