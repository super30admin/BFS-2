
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach BFS

// Used a queue to store the root
// Based on the size of the queue traversed the queue and then popped the element and checked the val with x and y
// added the elements children to the queue
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false, y_found = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x)
                    x_found = true;
                if (curr.val == y)
                    y_found = true;
                if (curr.left != null && curr.right != null && curr.left.val == x && curr.right.val == y)
                    return false;
                if (curr.left != null && curr.right != null && curr.left.val == y && curr.right.val == x)
                    return false;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
            if (x_found == true && y_found == true)
                return true;
            if (x_found || y_found)
                return false;
        }
        return false;

    }
}

// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach DFS

// Used a recursive approach
// took the level and parent
// if the root.val was equal to either x and y made that their parent and their
// level
// Atlast checked the conditions for them to be cousins
class Solution {
    int x_level, y_level;
    TreeNode x_parent, y_parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        dfs(root, x, y, 0, null);
        return x_parent != y_parent && x_level == y_level;

    }

    public void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        if (root == null)
            return;
        if (root.val == x) {
            x_parent = parent;
            x_level = level;
        }
        if (root.val == y) {
            y_parent = parent;
            y_level = level;
        }

        dfs(root.left, x, y, level + 1, root);
        dfs(root.right, x, y, level + 1, root);
    }
}