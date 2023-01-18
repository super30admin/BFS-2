// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BinaryTreeRightSideViewBFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) {
                    result.add(current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        return result;
    }
}

// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BinaryTreeRightSideViewRightRec {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        }
        dfs(root.right, level + 1, result);
        dfs(root.left, level + 1, result);
    }
}

// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class BinaryTreeRightSideViewLeftRec {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}