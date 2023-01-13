//tc : O(n)
//sc : O(n)
//Run success on leetcode
//NO problems 

//performed BFS using recurssion and checked the conditions for the 
//conditions, that are does not share a same parent and lie in 
//the same row

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
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        return helper(q, x, y);
    }

    public boolean helper(Queue<TreeNode> q, int x, int y) {
        boolean checkx = false, checky = false;
        Queue<TreeNode> next = new LinkedList<>();
        while (!q.isEmpty()) {
            TreeNode root = q.poll();

            if (root.left != null && root.right != null) {
                if (root.left.val == x && root.right.val == y)
                    return false;
                if (root.right.val == x && root.left.val == y)
                    return false;
            }

            if (root.val == x)
                checkx = true;
            else if (root.val == y)
                checky = true;
            if (root.left != null)
                next.add(root.left);
            if (root.right != null)
                next.add(root.right);
            if (checkx && checky)
                return true;
        }
        if (checkx || checky)
            return false;
        else
            return helper(next, x, y);
    }
}