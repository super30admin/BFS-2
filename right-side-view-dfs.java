import java.util.*;

//SC is O(h)
//TC is O(n)
class Solution {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        // logic
        if (result.size() == level) {
            result.add(root.val);
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}