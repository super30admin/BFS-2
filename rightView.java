// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//do level order traversal.maintain size at each level, check if we are at last element of the level if yes, add it into result
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
                if (i == size - 1) {
                    result.add(curr.val);
                }
            }
        }
        return result;
    }
}
// -----------------------------------DFS right first--------------------------

// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// using dfs, call right child first and add into result, going further check if
// for that level, ele is already there, if yes then no need to add anything. if
// no, add element
class Solution {
    private List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        // edge
        if (root == null)
            return;
        int size = result.size();
        if (level == size) {
            result.add(root.val);
        }
        // logic
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}

// ----------------------DFS left first-------------------
// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// using dfs, call left child first and add into result, going further check if
// for that level,
// ele is already there, if yes then replace. if no, add element
class Solution {
    private List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        // edge
        if (root == null)
            return;
        int size = result.size();
        if (level == size) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }

        // logic
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}