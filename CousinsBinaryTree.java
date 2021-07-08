class CousinsBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {

        //Time Complexity O(N)
        //Space Complexity O(max amount of nodes in queue)

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            boolean x_found = false;
            boolean y_found = false;

            for (int i =0; i<size; i++) {

                TreeNode node = q.poll();

                if (node.val == x) x_found = true;
                if (node.val == y) y_found = true;

                //Case where the nodes are found to be siblings
                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y) return false;
                    if (node.right.val == x && node.left.val == y) return false;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }

            if (x_found && y_found) {
                return true;
            }

            if (x_found || y_found) {
                return false;
            }


        }

        return false;

    }

}