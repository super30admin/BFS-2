/*
 * The time complexity of this implementation is O(n) and
 * space complexity is O(n)*/
import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class Cousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            TreeNode parentX = null;
            TreeNode parentY = null;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        foundX = true;
                        parentX = node;
                    } else if (node.left.val == y) {
                        foundY = true;
                        parentY = node;
                    }
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        foundX = true;
                        parentX = node;
                    } else if (node.right.val == y) {
                        foundY = true;
                        parentY = node;
                    }
                }
            }

            if (foundX && foundY && parentX != parentY) {
                return true;
            } else if (foundX || foundY) {
                return false;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        // Construct a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Test the isCousins method
        Cousins solution = new Cousins();
        boolean result = solution.isCousins(root, 4, 5);
        System.out.println(result); // Output: true
    }

}
