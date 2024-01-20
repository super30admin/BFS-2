/*
* Approach:
*  1. Apply BFS like level-order traversal.
* 
*  2. Update the result list with last element of each level.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(W) == O(n)
    width of tree
* 
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewBFS {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int index = 0; index < size; index++) {
                TreeNode curr = queue.poll();

                if (index == size - 1)
                    result.add(curr.val);

                if (curr.left != null)
                    queue.add(curr.left);

                if (curr.right != null)
                    queue.add(curr.right);
            }
        }

        return result;
    }
}
