/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class RightSideViewBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {

        // BFS
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentElement = q.poll();
                if (i == size - 1)
                    result.add(currentElement.val);
                if (currentElement.left != null) {
                    q.add(currentElement.left);
                }
                if (currentElement.right != null) {
                    q.add(currentElement.right);
                }
            }
        }

        return result;

    }
}

//DFS

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RightSideViewBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        // DFS
        List<Integer> res = new ArrayList<>();
        dfs(root, 0 , res);
        return res;
    }

    public void dfs(TreeNode root, int level, List<Integer> res) {
        // base
        if(root == null) return;

        if(res.size() == level) {
            res.add(root.val);
        }

        // right child
        dfs(root.right, level + 1, res);

        // left child
        dfs(root.left, level + 1, res);
    }
}