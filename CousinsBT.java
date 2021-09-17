// TIME: O(N)
// SPACE: O(N)
// SUCCESS on LeetCode

public class CousinsBT {
    TreeNode parentX;
    TreeNode parentY;
    int depthX;
    int depthY;
    public boolean isCousins(TreeNode root, int x, int y) {
        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null && node.right != null) {
                if (node.left.val == x && node.right.val == y || node.right.val == x && node.left.val == y) return false;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (list.contains(x) && list.contains(y)) return true;
        }
        
        return false; 
    }
}
