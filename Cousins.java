// Time Complexity :O(N)
// Space Complexity :O(H) and O(N) in worst case i.e. skew tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Call a recursive function which checks the depth and parent of X and Y
//2. In the final call to the reursive metjod we check if the depths are same and if the parents are not same then we 
//3. say that they are cousins.

class Cousins {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int ele) {
            val = ele;
        }
    }

    int depthX = -1, depthY = -1;
    TreeNode parentX = null, parentY = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        helper(root, x, y, 0, null);

        if (depthX == depthY && parentX != parentY)
            return true;

        else
            return false;
    }

    public void helper(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null)
            return;

        if (root.val == x) {
            depthX = depth;
            parentX = parent;
        }
        if (root.val == y) {
            depthY = depth;
            parentY = parent;
        }

        if (depthX != -1 && depthY != -1)
            return;

        helper(root.left, x, y, depth + 1, root);
        helper(root.right, x, y, depth + 1, root);
    }

    public static void main(String args[]) {

        TreeNode tree = new TreeNode(7);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(15);

        tree.left.left = new TreeNode(4);
        tree.right.left = new TreeNode(9);
        tree.right.right = new TreeNode(20);

        tree.right.left.right = new TreeNode(5);
        tree.right.right.right = new TreeNode(59);

        int x = 4, y = 20;
        Cousins obj = new Cousins();
        System.out.println(obj.isCousins(tree, x, y));

    }
}