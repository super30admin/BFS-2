import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(n) for BFS and O(1) for DFS
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/**
 * Right-side view of a binary tree means the last element on each level of the tree.
 * We can solve this problem using BFS and DFS.
 * DFS - We can start from the right side of the tree and keep track of the level of the tree.
 * If the size of the result is equal to the level of the tree, then we can add the element to the result.
 * BFS - We can use the level order traversal and add the last element of each level to the result.
 */


public class Problem1 {
    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) res.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }

        return res;

    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        //base
        if (root == null) return;

        //logic
        if (res.size() == level) res.add(root.val);
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
