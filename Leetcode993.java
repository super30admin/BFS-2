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
// Solution - Using BFS
// TC - O(n)
// SC - O(n) extra space for a queue. Its never of length n buut worst case can
// have n/2 size. Hence O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean res = false;
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return res;
        if (root.val == x || root.val == y)
            return res;
        q.add(root); // add root element to the array
        boolean xfound = false;
        boolean yfound = false;
        int xParent = -1; // Assign values of x & y parents to values of out bound
        int yParent = -1;
        while (!q.isEmpty()) { // iterate until q is empty.
            int size = q.size();
            for (int i = 0; i < size; i++) { // Process each element in the q at that level
                TreeNode node = q.poll();
                if (node.left != null) { // if processed node's left is not null, check if its equal to x or y and
                                         // assign xfound,
                    // xParent, yfound and yParent respectively.
                    if (node.left.val == x) {
                        xfound = true;
                        xParent = node.val;
                    }
                    if (node.left.val == y) {
                        yfound = true;
                        yParent = node.val;
                    }
                    q.add(node.left); // add current node's left child to the q
                }
                if (node.right != null) { // if processed node's right is not null, check if its equal to x or y and
                                          // assign xfound,
                    // xParent, yfound and yParent respectively.
                    if (node.right.val == x) {
                        xfound = true;
                        xParent = node.val;
                    }
                    if (node.right.val == y) {
                        yfound = true;
                        yParent = node.val;
                    }
                    q.add(node.right); // add current node's right child to the q
                }
            }
            if (xfound && yfound) { // If both x and y are found

                if (xParent == yParent) { // check thier parent's value.
                    return false;
                } else {
                    return true;
                }
            } else if (xfound || yfound) { // If either is found, that means they are not cousins/not in same level
                return false;
            }

        }
        return true;
    }
}

// Solution - Using DFS
// TC - O(n)
// SC - O(n) Recursion Stack
// class Solution {
// int xLevel;
// int yLevel;
// int xParent;
// int yParent;

// public boolean isCousins(TreeNode root, int x, int y) {
// this.xLevel = -1;
// this.yLevel = -2;
// this.xParent = -1;
// this.yParent = -2;

// helper(root, x, y, 0);
// if(xLevel == yLevel && xParent != yParent){
// return true;
// }
// return false;

// }

// private void helper(TreeNode node, int x, int y, int level) {
// // Base
// if(node == null) return;

// // Logic
// if(node.left != null) {
// if(node.left.val == x) {
// xParent = node.val;
// xLevel = level +1;
// }
// else if(node.left.val == y) {
// yParent = node.val;
// yLevel = level +1;
// } else {
// helper(node.left, x,y, level+1);
// }
// }

// if(node.right != null ) {
// if(node.right.val == x) {
// xParent = node.val;
// xLevel = level +1;
// }
// else if(node.right.val == y) {
// yParent = node.val;
// yLevel = level +1;
// } else {
// helper(node.right, x,y, level+1);
// }
// }

// }

// }
