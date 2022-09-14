// Time complexity: O(N) as we are traversing all nodes of the tree
// Space complexity: O(N) as we maintain a queue

// Approach: run BFS. when visiting nodes level by level, we add the right most node's value to our result by checking if the index i in the for loop is equal to size - 1 as that is the last node at that level.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == size-1) { // if node is right most node of current level, add it to the result
                    result.add(curr.val);
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return result;
    }
}