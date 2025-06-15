class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean x_found = false;
            boolean y_found = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Check if x or y found at this level
                if (node.val == x)
                    x_found = true;
                if (node.val == y)
                    y_found = true;

                // Check if x and y are siblings (have same parent)
                if (node.left != null && node.right != null) {
                    int leftVal = node.left.val;
                    int rightVal = node.right.val;

                    if ((leftVal == x && rightVal == y) ||
                            (leftVal == y && rightVal == x)) {
                        return false; // they are siblings, not cousins
                    }
                }

                // Add children to queue
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            // After processing one level
            if (x_found && y_found)
                return true; // same level, not siblings → cousins
            if (x_found || y_found)
                return false; // only one found → not cousins
        }

        return false; // not found
    }
}

//
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // add children to the queue
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

                // if it's the last node in this level
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
            }
        }

        return result;
    }
}
