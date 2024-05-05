package BFS-2;
// TC: O(n)
// SC: O(n)
public class Problem2 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            boolean x_found = false, y_found = false;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                if (currNode.val == x) {
                    x_found = true;
                }
                if (currNode.val == y) {
                    y_found = true;
                }
                if (currNode.left != null && currNode.right != null) {
                    if (currNode.left.val == x && currNode.right.val == y)
                        return false;
                    if (currNode.left.val == y && currNode.right.val == x)
                        return false;
                }
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
            if (x_found && y_found)
                return true;
            if (x_found || y_found)
                return false;
        }
        return false;
    }
}
