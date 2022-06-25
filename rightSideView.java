// BFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//DFS
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes I was confused that Why this only working on preorder traversal.
// Can you give me idea?

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {

    // BFS approch
    public static List<Integer> rightSideView1(TreeNode root) {
        // to store result;
        List<Integer> result = new ArrayList<>();
        // null case
        if (root == null)
            return result;

        // Queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        // add root to the queue
        q.add(root);
        // BFS traversal
        while (!q.isEmpty()) {
            // getting size of the queue for level
            int size = q.size();
            // to store last element at perticular level
            int last = 0;
            // visit all the nodes at the level
            for (int i = 0; i < size; i++) {
                // getting current element (first element in queue)
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
                // I am updating last element in for loop
                last = cur.val;
            }
            // add last element at particular level to result;
            result.add(last);
        }
        return result;
    }

    private static List<Integer> result;

    // DFS approch
    public static List<Integer> rightSideView2(TreeNode root) {
        // to store result;
        result = new ArrayList<>();
        // null case
        if (root == null)
            return result;
        // dfs
        dfs(root, 0);
        return result;
    }

    private static void dfs(TreeNode root, int level) {

        // here I am using level to store in result
        if (root == null)
            return;
        // if level == result size that means we are first node visitng at this level so
        // we add it into result
        // or we set this element
        if (level == result.size()) {
            result.add(root.val);
        } else {
            result.set(level, root.val);
        }
        // left traversal
        dfs(root.left, level + 1);
        // right traversal
        dfs(root.right, level + 1);
        // System.out.println(root.val + " " + level);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(rightSideView1(root));
        System.out.println(rightSideView2(root));

    }
}