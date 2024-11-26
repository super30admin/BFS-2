// Time complexity: O(n) Each node is visited once
// Space Complexity: O(d) where d is the width of the tree

import java.util.LinkedList;
import java.util.Queue;

public class CousinsBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y ){

        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            boolean xFound = false;
            boolean yFound = false;

            for (int i =0; i < size; i++) {
                TreeNode current = queue.poll();

                // check if x and y are siblings or not
                if (current.left != null && current.right != null) {
                    if ((current.left.val == x && current.right.val == y) ||
                            (current.left.val == y && current.right.val == x)) {
                        return false;
                    }
                }

                if (current.val == x) xFound = true;
                if (current.val == y) yFound = true;
                ;
                // add children to the queue
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            if(xFound && yFound) return true;
            if(xFound || yFound) return false;

            }

        return false;
        }

    public static void main (String [] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        CousinsBinaryTree solution = new CousinsBinaryTree();
        int x =4, y = 5;

        // Getting the right side view of the binary tree
        boolean result = solution.isCousins(root, x, y);

        // Printing the result
        System.out.println("Are these cousins : " + result);
    }


    }

