//using dfs

//TC: O(n) where n is the no. of nodes
//SC: O(h) for recursive stack , where h is the height of the tree

//CODE:

class Solution {
    TreeNode x_parent;
    TreeNode y_parent;
    int x_h; // x height
    int y_h;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return x_parent != y_parent && x_h == y_h; // return true if parents are not equal and heights are same
    }

    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        // base
        if (root == null)
            return;

        // logic
        if (root.val == x) { // if we found x , then mark its paremt and height
            x_parent = parent;
            x_h = level;
        }
        if (root.val == y) {
            y_parent = parent;
            y_h = level;
        }
        dfs(root.left, x, y, level + 1, root); // call dfs for left and right child by increasing level by 1.
        dfs(root.right, x, y, level + 1, root);
    }
}

// using bfs

// TC: O(n)
// SC: O(n) for storing TreeNodes in queue

// CODE:

// going through bfs traversal .
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x)
                    x_found = true; // if we find x and y make the flag as true
                if (curr.val == y)
                    y_found = true;
                // checking if x and y are babies of same parent ; if they are babies of same
                // parent it means they are not cousins , so return false
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.right.val == x && curr.left.val == y)
                        return false;
                }
                // adding left and right child in queue
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }
            if (x_found && y_found)
                return true; // if both are found , then return true . We already checked for the parents
                             // earlier.
            if (x_found || y_found)
                return false; // if one of the is found it means other one is at different level , so return
                              // false.
        }
        return false;
    }
}
