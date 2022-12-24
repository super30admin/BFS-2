// Time Complexity : O(n)
// Space Complexity : O(n). -> (n/2) -> all leaf nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three sentences only
/*
 * we create a queue to all the leaf nodes, we check size after adding all noeds for a level.
 * We need to get the right side of every level so, just add the size - 1 value to the result.
 * For next steps, add the left and right side child of the nodes.
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
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

// Right Recursive Call

// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Use DFS approach for right recursive call first.
 * we keep track of level at every dfs call and check whether size of the result
 * is equal to level, add the val in the result. this will add all the right
 * side view of the tree.
 * we call dfs 1st from right side and then left side.
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfs(root, 0, result);

        return result;
    }

    private void dfs(TreeNode root, int level, List<Integer> result) {
        // base

        if (root == null)
            return;

        // logic
        if (result.size() == level) {
            result.add(root.val);
        }
        dfs(root.right, level + 1, result);

        dfs(root.left, level + 1, result);
    }
}

// Left Recursive Call

// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * Use DFS approach for left recursive call first.
 * we keep track of level at every dfs call and check whether size of the result
 * is equal to level, add the val in the result oe else if the level is already
 * is present, we set the level to the new root value
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        dfs(root, 0, result);

        return result;
    }

    private void dfs(TreeNode root, int level, List<Integer> result) {
        // base

        if (root == null)
            return;

        // logic
        if (result.size() == level) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        dfs(root.left, level + 1, result);

        dfs(root.right, level + 1, result);
    }
}