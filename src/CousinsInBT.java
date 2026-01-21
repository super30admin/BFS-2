import java.util.LinkedList;
import java.util.Queue;

/*
LeetCode 993. Cousins in Binary Tree
Two nodes are cousins if:
1) They are at the same depth (level)
2) They have different parents
Time Complexity (all): O(n)  -> visit each node at most once
Space Complexity:
- BFS: O(w) where w is max width of tree (worst O(n))
- DFS: O(h) recursion stack where h is height (worst O(n), balanced O(log n))
*/
public class CousinsInBT {

    // Basic tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Approach 1: BFS with parent tracking (clean version)
    /*
     Idea:
     - Do level order traversal.
     - For each node, also carry its parent.
     - At each level, check if x and y are found and compare parents.
     */
    static class NodeWithParent {
        TreeNode node;
        TreeNode parent;
        NodeWithParent(TreeNode node, TreeNode parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<NodeWithParent> queue = new LinkedList<>();
        queue.add(new NodeWithParent(root, null));

        while (!queue.isEmpty()) {
            int size = queue.size();

            TreeNode xParent = null;
            TreeNode yParent = null;

            for (int i = 0; i < size; i++) {
                NodeWithParent cur = queue.poll();
                TreeNode node = cur.node;
                TreeNode parent = cur.parent;

                if (node.val == x) xParent = parent;
                if (node.val == y) yParent = parent;

                if (node.left != null) queue.add(new NodeWithParent(node.left, node));
                if (node.right != null) queue.add(new NodeWithParent(node.right, node));
            }

            // After finishing one level:
            if (xParent != null && yParent != null) {
                return xParent != yParent; // same level + different parents
            }
            if (xParent != null || yParent != null) {
                return false; // found only one at this level -> not cousins
            }
        }

        return false;
    }

    //Approach 2: BFS using one queue
    /*
     Idea:
     - Still do BFS per level.
     - Check if x and y are siblings (same parent). If yes -> false.
     - Track if x and y appear in the same level. If yes -> true.
     */
    public boolean isCousinsUsingAQueue(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // sibling check: if children are x and y in any order -> not cousins
                if (node.left != null && node.right != null) {
                    int lv = node.left.val;
                    int rv = node.right.val;
                    if ((lv == x && rv == y) || (lv == y && rv == x)) {
                        return false;
                    }
                }

                if (node.val == x) xFound = true;
                if (node.val == y) yFound = true;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            // After finishing one level:
            if (xFound && yFound) return true;
            if (xFound || yFound) return false;
        }

        return false;
    }

    // Approach 3: DFS (record level + parent)
    /*
     Idea:
     - Traverse the tree and record:
       x_level, x_parent
       y_level, y_parent
     - Cousins if levels are equal and parents are different.
     */
    private int x_level, y_level;
    private TreeNode x_parent, y_parent;

    public boolean isCousinsUsingDFS(TreeNode root, int x, int y) {
        // reset fields so multiple calls work correctly
        x_level = -1;
        y_level = -1;
        x_parent = null;
        y_parent = null;

        helper(root, x, y, 0, null);

        return x_level == y_level && x_parent != y_parent;
    }

    private void helper(TreeNode root, int x, int y, int level, TreeNode parent) {
        if (root == null) return;

        if (root.val == x) {
            x_level = level;
            x_parent = parent;
        } else if (root.val == y) {
            y_level = level;
            y_parent = parent;
        }

        // Optional pruning: if both found, stop exploring further
        if (x_parent != null && y_parent != null) return;

        helper(root.left, x, y, level + 1, root);
        helper(root.right, x, y, level + 1, root);
    }

    //Simple main method to test
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CousinsInBT t = new CousinsInBT();

        System.out.println("Tree: [1,2,3,null,4,null,5]");
        System.out.println("x=4, y=5");

        System.out.println("BFS w/ parent tracking: " + t.isCousins(root, 4, 5));
        System.out.println("BFS single queue       : " + t.isCousinsUsingAQueue(root, 4, 5));
        System.out.println("DFS                    : " + t.isCousinsUsingDFS(root, 4, 5));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        System.out.println();
        System.out.println("Tree2: [1,2,3,4,5]");
        System.out.println("x=4, y=5");

        System.out.println("BFS w/ parent tracking: " + t.isCousins(root2, 4, 5));
        System.out.println("BFS single queue       : " + t.isCousinsUsingAQueue(root2, 4, 5));
        System.out.println("DFS                    : " + t.isCousinsUsingDFS(root2, 4, 5));
    }
}
