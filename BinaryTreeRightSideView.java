/*
* The time complexity of this implementation is O(n) and
* space complexity is O(w) where w is max width*/
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Print the right side view of the binary tree
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        List<Integer> rightSideView = solution.rightSideView(root);
        System.out.println(rightSideView);
    }

}
