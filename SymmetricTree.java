// Time Complexity  O(n) each node is visited exactly once
// Space complexity O(w) the space required is due to the queue used for level-order traversal, where w is the maximum width of the tree.
//In the best case (balanced tree)w=n/2 (the number of leaf nodes).
//In the worst case (skewed tree),𝑤 =1

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {

            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue; // both are null - continue
            if (t1 == null || t2 == null) return false; // both are not null
            if (t1.val != t2.val) return false; // values are different

            // add the children in mirrored order

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;
    }

    public static void main (String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree solution = new SymmetricTree();
        System.out.println("Is the tree symmetric? " + solution.isSymmetric(root)); // Output: true
    }
}
