import java.util.LinkedList;
import java.util.Queue;

/*
Using BFS Level order traversal approach
Time Complexity -> O(N)
Space Complxity -> O(N)
*/

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean is_Xvalid = false;
        boolean is_YValid = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if (curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                if (curr.val == x) {
                    is_Xvalid = true;
                }
                if (curr.val == y) {
                    is_YValid = true;
                }
            }
            if (is_Xvalid && is_YValid) {
                return true;
            }
            if (is_Xvalid || is_YValid) {
                return false;
            }
        }
        return true;
    }
}

/*
Using DFS 
Time Complexity -> O(N)
Space Complxity -> O(h)
*/

class Solution2 {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_level;
    int y_level;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        x_parent = null;
        y_parent = null;
        x_level = -1;
        y_level = -1;
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_level == y_level;
    }

    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y) {

        if(root == null) {
            return;
        }
        if(root.val == x) {
            x_parent = parent;
            x_level = level;
        }
         if(root.val == y) {
            y_parent = parent;
            y_level = level;
        }
        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}