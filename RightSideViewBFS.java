// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Intuition: We can use either BFS or DFS to traverse the tree. 

import java.util.*;
import java.util.LinkedList;

public class RightSideViewBFS {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> result = new ArrayList();

        if (root == null)
            return result;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Intuition: We can use BFS/DFS to traverse the tree level by level.

class RightSideViewDFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null)
            return result;
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null)
            return;
        if (result.size() == level) {
            result.add(node.val);
        }
        // Note: We traverse right first to ensure the rightmost node at each level is
        // added first
        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);

        // Alternative approach for left first: If you want to overwrite the value at
        // the current level
        // if(result.size() == level){
        // result.add(node.val);
        // } else {
        // result.set(level, node.val);
        // }
        // dfs(node.left, level+1, result);
        // dfs(node.right, level+1, result);
    }
}
