// time complexity- O(n) where n is the number of tree nodes
// space complexity- O(n)
import java.util.*;
public class CousinsInBinaryTree {
    static  private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if (depthOfNode(root, x) == depthOfNode(root, y)) {
            return !isParent(root, x, y);
        }

        return false;
    }

    public int depthOfNode(TreeNode root, int val) {
        int level = 0;
        Queue<TreeNode> node = new LinkedList<>();

        node.offer(root);
        while (!node.isEmpty()) {
            int len = node.size();
            for (int i = 0; i < len; i++) {
                TreeNode temp = node.poll();
                if (temp.val == val) {
                    level++;
                    return level;
                }
                if (temp.left != null)
                    node.offer(temp.left);
                if (temp.right != null)
                    node.offer(temp.right);
            }
            level++;
        }

        return level;
    }

    public boolean isParent(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        if (root.left != null && root.right != null) {
            if (root.left.val == x && root.right.val == y)
                return true;
            if (root.left.val == y && root.right.val == x)
                return true;
        }

        return isParent(root.left, x, y) || isParent(root.right, x, y);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        CousinsInBinaryTree tree = new CousinsInBinaryTree();
        System.out.println("Are they cousins (2 and 3)? " + tree.isCousins(root, 2, 3));
        System.out.println("Are they cousins (4 and 5)? " + tree.isCousins(root, 5, 4));

    }
}
