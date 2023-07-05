import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CousinsInBT {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        // Queue<Integer> q = new LinkedList<>();
        q.add(root);
        // q.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false, y_found = false;
            System.out.print((Arrays.toString(q.toArray())));
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.val == x)
                    x_found = true;
                if (curr.val == y)
                    y_found = true;
                // if(i == size){
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.left.val == y && curr.right.val == x)
                        return false;
                    // if(curr.left.val ==null || curr.right == null) return false;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            if (x_found && y_found)
                return true;
            if (x_found || y_found)
                return false;

        }
        return false;
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CousinsInBT cousinsInBT = new CousinsInBT();

        int x = 4;
        int y = 5;

        // Call the isCousins method and print the result
        boolean result = cousinsInBT.isCousins(root, x, y);
        System.out.println("Are " + x + " and " + y + " cousins? " + result);
    }
}
