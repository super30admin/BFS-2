class BinaryTreeRightSideView {

    //Time Complexity; O(n) n being the number of nodes
    //Space Complexity: O(n) max amount of nodes in the queue at one time
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Queue <TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i=0; i<size; i++) {
                TreeNode curr = q.poll();

                if (i == size - 1) {
                    list.add(curr.val);
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

        }

        return list;


    }

}