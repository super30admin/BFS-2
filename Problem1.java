// Time Complexity : O(n)
// Space Complexity : O(D) diameter of the tree. N/2 in case of complete binarytree 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


//By BFS approach add treeNode to the queue. as we are travesing inorder
//always add last element value to the list in each level. the last element will be
//right view.

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Problem1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) {
                    result.add(curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example Usage
        // Create a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Problem1 solution = new Problem1();
        List<Integer> result = solution.rightSideView(root);

        // Print the result
        System.out.println("Right Side View: " + result);
    }
}
