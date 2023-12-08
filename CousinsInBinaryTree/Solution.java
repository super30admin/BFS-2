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

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Use BFS. Traverse the tree using bfs. At each level, find x & y. If both found, if the parents are same, return false, else return true.
 * If just 1 is found, return false. If none found, visit next level.
 */

/**
 * BFS without SPACE
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();

        boolean xFound = false;
        boolean yFound = false;
        TreeNode xParent = null;
        TreeNode yParent = null;

        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node.val == x)
                    xFound = true;

                if(node.val == y)
                    yFound = true;

                if(node.left != null && node.right != null) {
                    if(node.left.val == x && node.right.val == y) return false;
                    if(node.left.val == y && node.right.val == x) return false;
                }

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }

            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }

        return false;
    }
}

/**
 * BFS with SPACE
 */
/*
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> parentQ = new LinkedList<>();

        boolean xFound = false;
        boolean yFound = false;
        TreeNode xParent = null;
        TreeNode yParent = null;

        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                TreeNode parent = parentQ.poll();

                if(node.val == x) {
                    xFound = true;
                    xParent = parent;
                }

                if(node.val == y) {
                    yFound = true;
                    yParent = parent;
                }

                if(node.left != null) {
                    q.add(node.left);
                    parentQ.add(node);
                }

                if(node.right != null) {
                    q.add(node.right);
                    parentQ.add(node);
                }
            }

            if(xFound && yFound) return xParent != yParent;
            if(xFound || yFound) return false;
        }

        return false;
    }
}*/

/**
 * DFS method 1
 */

/*class Solution {

    int x;
    int y;
    int xLevel;
    int yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {

        this.x = x;
        this.y = y;
        this.xLevel = -1;
        this.yLevel = -2;

        helper(root, 0, null);

        return xLevel == yLevel;
    }

    private void helper(TreeNode root, int level, TreeNode parent) {

        if(root == null) return;

        if(root.left != null && root.right != null) {
            if(root.left.val == x && root.right.val == y) return;
            if(root.left.val == y && root.right.val == x) return;
        }

        if(root.val == x)
            xLevel = level;

        if(root.val == y)
            yLevel = level;

        helper(root.left, level+1, root);
        helper(root.right, level+1, root);
    }
}*/

/**
 * DFS method 2
 */

/*class Solution {

    int x;
    int y;
    int xLevel;
    int yLevel;
    TreeNode xParent;
    TreeNode yParent;

    public boolean isCousins(TreeNode root, int x, int y) {

        this.x = x;
        this.y = y;
        this.xLevel = -1;
        this.yLevel = -1;
        this.xParent = null;
        this.yParent = null;

        helper(root, 0, null);

        return xLevel == yLevel && xParent != yParent;
    }

    private void helper(TreeNode root, int level, TreeNode parent) {

        if(root == null) return;
        if(xLevel != -1 && yLevel != -1) return;

        if(root.val == x) {
            xLevel = level;
            xParent = parent;
        }

        if(root.val == y) {
            yLevel = level;
            yParent = parent;
        }

        helper(root.left, level+1, root);
        helper(root.right, level+1, root);
    }
}*/
