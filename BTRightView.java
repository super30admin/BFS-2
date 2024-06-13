/***
 Approach - Using BFS and level order traversal
 TC - O(n), SC - O(n)
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class BTRightView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(i == size -1)
                    result.add(curr.val);

                if(curr.left != null)
                    queue.add(curr.left);

                if(curr.right != null)
                    queue.add(curr.right);
            }
        }

        return result;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}