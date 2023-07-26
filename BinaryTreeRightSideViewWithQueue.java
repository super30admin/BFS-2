package BFS2;

// Time Complexity : O(n)
// Space Complexity : O(n)   //max number of leaf nodes;
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideViewWithQueue {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {

        this.result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();

                if (temp != null) {
                    if (i == size - 1) {
                        result.add(temp.val);
                    }
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }
        }

        return result;
    }
}
