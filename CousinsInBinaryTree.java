
import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int val) {
        this.val = val;
    }
}

class CousinsInBinaryTree {
    public boolean isCousins(Node root, int x, int y) {
        if (root == null) return false;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            boolean xfound = false;
            boolean yfound = false;

            for (int i = 0; i < count; i++) {
                Node node = q.poll();

                if (node.val == x) xfound = true;
                if (node.val == y) yfound = true;

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (xfound && yfound) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        CousinsInBinaryTree sol = new CousinsInBinaryTree();
        boolean result = sol.isCousins(root, 4, 3);
        System.out.println("Are 4 and 3 cousins? " + result); // Output: false
    }
}
