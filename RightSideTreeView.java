// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {

    List<Integer> ans = new ArrayList<>();
    // TreeMap<Integer, Integer> map = new TreeMap<>();

    private void helper(TreeNode root, int level) {

        if (root == null) return;

        // Process only if arrived for the first time
        if (ans.size() == level) ans.add(level, root.val);

        helper(root.right, level + 1);

        helper(root.left, level + 1);


    }

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) return ans;

        helper(root, 0);

        // for (int i : map.values()) ans.add(i);

        return ans;
    }
}