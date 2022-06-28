// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//993. Cousins in Binary Tree
//https://leetcode.com/problems/cousins-in-binary-tree/


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
    // BFS approach
    // time: O(n)
    // space: O(n) - extra queue space
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean flagX = true;
        boolean flagY = true;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag = false;
        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;
        q.add(root);
        count = 1;
        int size = count;
        count = 0;

        while (!q.isEmpty()) {
            // check if x and y are the elements
            // then check if x and y have the same parent using flags

            TreeNode temp = q.peek();

            // if(((temp.left != null && x == temp.left.val) && (temp.right != null && y ==
            // temp.right.val)) || ((temp.right != null && x == temp.right.val) &&
            // (temp.left != null && y == temp.left.val))) flagX = false;

            // if(((temp.left != null && y == temp.left.val) && (temp.right != null && x ==
            // temp.right.val)) || ((temp.right != null && y == temp.right.val) &&
            // (temp.left != null && x == temp.left.val))) flagY = false;

            System.out.println("flagX " + flagX);
            System.out.println("flagY " + flagY);
            System.out.println("peek " + q.peek().val);
            // if(flagX && flagY){
            for (int i = 0; i < size; i++) {
                // then push in the queue
                temp = q.remove();
                System.out.println("temp " + temp.val);
                if (temp.val == x)
                    flag1 = true;
                if (temp.val == y)
                    flag2 = true;
                if (temp.left != null) {
                    if (((temp.left != null && x == temp.left.val) && (temp.right != null && y == temp.right.val))
                            || ((temp.right != null && x == temp.right.val)
                                    && (temp.left != null && y == temp.left.val)))
                        flagX = false;
                    if (flagX) {
                        q.add(temp.left);
                        count++;
                    }
                }
                if (temp.right != null) {
                    if (((temp.left != null && y == temp.left.val) && (temp.right != null && x == temp.right.val))
                            || ((temp.right != null && y == temp.right.val)
                                    && (temp.left != null && x == temp.left.val)))
                        flagY = false;

                    if (flagY) {
                        q.add(temp.right);
                        count++;
                    }
                }
            }
            // }

            if ((flag1 == true && flag2 == false) || (flag1 == false && flag2 == true)) {
                flag = false;
                break;
            } else if (flag1 && flag2) {
                flag = true;
                break;
            }
            size = count;
            count = 0;
        }
        return flag;

    }
}
/*
 * class Solution {
 * //DFS approach
 * //time: O(n)
 * //space: O(h)
 * TreeNode parentX = null;
 * TreeNode parentY = null;
 * int X;
 * int Y;
 * int levelX;
 * int levelY;
 * public boolean isCousins(TreeNode root, int x, int y) {
 * X = x;
 * Y = y;
 * helper(root, 0, null);
 * if(levelX == levelY && parentX != parentY) return true;
 * else return false;
 * }
 * 
 * private void helper(TreeNode root, int level, TreeNode parent){
 * //base
 * if(root == null) return;
 * System.out.println(X); System.out.println(Y); System.out.println(root.val);
 * //logic
 * if(root.val == X){
 * parentX = parent;
 * levelX = level;
 * }
 * if(root.val == Y){
 * parentY = parent;
 * levelY = level;
 * }
 * helper(root.left, level+1, root);
 * 
 * helper(root.right, level+1, root);
 * 
 * }
 * }
 */
