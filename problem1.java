//T.C-O(n)
//S.C-O(n)
//passed all test cases
//the approach is to keep a level variable and check wheather the level is visited or not .
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al = new ArrayList<Integer>();
        helper(root, 0, al);
        return al;
    }

    public void helper(TreeNode root, int level, List<Integer> al) {
        // base
        if (root == null)
            return;
        // logic
        if (level == al.size()) {
            al.add(root.val);
        }
        helper(root.right, level + 1, al);
        helper(root.left, level + 1, al);
    }
}