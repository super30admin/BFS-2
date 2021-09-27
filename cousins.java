/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class cousins {
    // //TC: O(N) // SC: O(N)

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
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.right.val == x && curr.left.val == y)
                        return false;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
            if (x_found && y_found)
                return true;
            if (x_found || y_found)
                return false;
        }
        return false;
    }

}

// TC: O(N) // SC: O(N)
// TreeNode x_parent; TreeNode y_parent;
// int x_depth, y_depth;
// public boolean isCousins(TreeNode root, int x, int y) {
// if(root == null) return false;
// dfs(root, x, y, 0, null);
// return x_depth == y_depth && x_parent != y_parent;
// }

// private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
// if(root == null) return;

// if(root.val == x){
// x_depth = depth;
// x_parent = parent;
// }
// if(root.val == y){
// y_depth = depth;
// y_parent = parent;
// }
// dfs(root.left, x, y, depth + 1, root);
// dfs(root.right, x, y, depth + 1, root);
// }
