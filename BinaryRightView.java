// Time Complexity o(n) space complexity o(h);
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        helper(root, 0, arr);
        return arr;
    }

    public void helper(TreeNode root, int level, List<Integer> arr) {
        if (root == null)
            return;

        if (level == arr.size()) {
            arr.add(root.val);
        } else {
            arr.set(level, root.val);
        }
        helper(root.left, level + 1, arr);
        helper(root.right, level + 1, arr);
    }
}
