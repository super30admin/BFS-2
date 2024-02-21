// Time complexity: O(n)
// Space complexity: O(h)

//Approach: Only adding items if this is the first time at a certain level

import java.util.ArrayList;
import java.util.List;

class RightSideView {
    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        this.res = new ArrayList();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int height) {
        if (node == null) {
            return;
        }

        // first time visiting this level
        if (height == res.size()) {
            res.add(node.val);
        }

        dfs(node.right, height + 1);
        dfs(node.left, height + 1);
    }
}