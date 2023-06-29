public class MorrisInOrderTraversalBST {

        /* Function to traverse a
        binary tree without recursion
        and without stack */

        public void MorrisInOrder(TreeNode root) {

            // base
            if(root == null ) return;

            TreeNode curr = root;
            TreeNode pred;

            while(curr != null) {

                if(curr.left == null) {

                    System.out.println(curr.val);
                    curr = curr.right;
                }
                else {
                    // Find the inorder predecessor of current
                    pred = curr.left;

                    while(pred.right != null && pred.right != curr) {

                        pred = pred.right;
                    }

                    //  Make current as right child of its  inorder predecessor
                    if(pred.right == null) {

                        pred.right = curr;
                        curr = curr.left;
                    }

                    /*Revert the changes made in the 'if' part to restore the original tree i.e.,
                    fix the right child of predecessor */
                    else {

                        pred.right = null;
                        System.out.println(curr.val);
                        curr = curr.right;
                    }
                }
            }

        }


}
/* Time Complexity: Average = O(N) as leaf nodes take O(1) to reach right most node
and it is the case with majority of nodes, so Average time complexity remains O(N) whereas worst can be O(N^2)

Space Complexity = O(1) as there is no stack
 */
