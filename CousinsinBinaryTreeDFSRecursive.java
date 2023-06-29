public class CousinsinBinaryTreeDFSRecursive {

    // DFS - Recursion

        TreeNode parentX; TreeNode parentY;
        int depthX; int depthY;

        public boolean isCousins(TreeNode root, int x, int y) {

            cousinBFS(root, null, 0, x, y);

            return depthX == depthY && parentX != parentY;

        }

        private void cousinBFS(TreeNode root, TreeNode parent, int depth, int x, int y) {

            //base
            if(root == null) return;

            //logic
            if(root.val == x) {

                depthX = depth;
                parentX = parent;
            }

            if(root.val == y) {

                depthY = depth;
                parentY = parent;
            }

            if(parentX == null || parentY == null) {

                cousinBFS(root.left, root, depth+1, x, y);
            }

            if(parentX == null || parentY == null) {

                cousinBFS(root.right, root, depth+1, x, y);
            }
        }

}

/* Time Complexity = O(N)
Space Complexity = O(N) = O(H) */

