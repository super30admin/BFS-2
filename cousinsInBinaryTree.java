// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Time Complexity = O(n)
// Space Complexity = O(h)
// DFS Solution: Have x_level, y_level, x_parent and y_parent as global variables, and traverse the tree recursively in a DFS manner to find x and y and update the global variables.
// The return statuement would be x_level == y_level && x_parent != y_parent
class Solution {
    int x_level, y_level;
    TreeNode x_parent, y_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, null);
        return (x_level == y_level && x_parent != y_parent);
    }

    private void dfs(TreeNode root, int x, int y, int lvl, TreeNode parent) {
        // base
        if (root == null || (x_parent != null && y_parent != null)) return;

        //logic
        if(root.val == x) {
            x_level = lvl;
            x_parent = parent;
        }
        else if(root.val == y) {
            y_level = lvl;
            y_parent = parent;
        }

        //recurse
        dfs(root.left, x, y, lvl+1, root);  //left
        dfs(root.right, x, y, lvl+1, root);  //right
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)
// BFS Solution: me use Queue to store nodes in level order, and we maintain a size variable which will indicate each level
// if the children of a nod are x and y, we return false, we return true if we found both x and y in the same level
class Solution {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean x_found = false, y_found = false;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.val == x) {
                    x_found = true;
                }
                if(node.val == y) {
                    y_found = true;
                }

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                // At the end of each level check if we found the x and y values
                if(x_found == true && y_found == true) {
                    return true;
                }

                if(node.left != null) {
                    q.add(node.left);
                }

                if(node.right != null) {
                    q.add(node.right);
                }
            }
            if(x_found == true || y_found == true) {
                return false;
            }
        }

        return false;
    }
}