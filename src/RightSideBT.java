import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
LeetCode 199. Binary Tree Right Side View
Goal:
Return the values of the nodes you can see when looking at the tree from the right side.
That means: for each level, pick the "rightmost" node.
*/
public class RightSideBT {

    // Basic tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    /*
     APPROACH 1: BFS (Level Order Traversal)
     Idea:
     - Use a queue to traverse level by level.
     - At each level, the last node polled (i == size-1) is the rightmost node.

     Time Complexity: O(n)
       - each node enters and leaves the queue once
     Space Complexity: O(w)
       - w is max width of the tree (worst case O(n))
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size(); // number of nodes at current level

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // last node in this level is the rightmost
                if (i == size - 1) {
                    res.add(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

    /*
     APPROACH 2: DFS (Depth First Search) with level tracking
     Idea:
     - Traverse the tree and track 'level' (depth).
     - Store the value at res[level].
     - If this is the first time we reach this level (level == res.size()), add it.
     - Otherwise, overwrite it. Since we traverse left then right, the right child visited later
       overwrites the left value, so res[level] ends up holding the rightmost node value.
     Time Complexity: O(n)
     Space Complexity: O(h)
       - recursion stack height h (worst O(n), balanced O(log n))
     */
    public List<Integer> rightSideViewUsingDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;

        // If first time reaching this level, add.
        // Otherwise overwrite so the last visited node at this level (rightmost) remains.
        if (level == res.size()) {
            res.add(root.val);
        } else {
            res.set(level, root.val);
        }

        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }

    //  Simple main method to test
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightSideBT t = new RightSideBT();

        List<Integer> bfs = t.rightSideView(root);
        System.out.println("Right Side View (BFS): " + bfs);

        List<Integer> dfs = t.rightSideViewUsingDFS(root);
        System.out.println("Right Side View (DFS): " + dfs);

        TreeNode root2 = new TreeNode(3);
        root2.right = new TreeNode(7);
        root2.right.left = new TreeNode(6);

        System.out.println();
        System.out.println("Right Side View (BFS) tree2: " + t.rightSideView(root2));
        System.out.println("Right Side View (DFS) tree2: " + t.rightSideViewUsingDFS(root2));
    }
}
