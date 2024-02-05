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

/*
 * class Solution {
 * //Tc: O(n) Sc: O(n)
 * public boolean isCousins(TreeNode root, int x, int y) {
 * if (root == null)
 * return false;
 * 
 * Queue<TreeNode> queue = new LinkedList<>();
 * queue.add(root);
 * 
 * while (!queue.isEmpty()) {
 * int size = queue.size();
 * boolean foundX = false;
 * boolean foundY = false;
 * 
 * for (int i = 0; i < size; i++) {
 * TreeNode node = queue.poll();
 * 
 * if (node.val == x)
 * foundX = true;
 * if (node.val == y)
 * foundY = true;
 * 
 * if (node.left != null && node.right != null) {
 * if ((node.left.val == x && node.right.val == y) || (node.left.val == y &&
 * node.right.val == x)) {
 * return false;
 * }
 * }
 * 
 * if (node.left != null)
 * queue.add(node.left);
 * if (node.right != null)
 * queue.add(node.right);
 * }
 * 
 * if (foundX && foundY) {
 * return true;
 * }
 * 
 * else if (foundX || foundY) {
 * return false;
 * }
 * }
 * return false;
 * 
 * }
 * }
 */

/*
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
 * 
 * 
 * /*
 * class Solution {
 * public boolean isCousins(TreeNode root, int x, int y) {
 * if (root == null) return false;
 * 
 * Queue<TreeNode> queue = new LinkedList<>();
 * queue.add(root);
 * 
 * while (!queue.isEmpty()) {
 * int size = queue.size();
 * boolean foundX = false;
 * boolean foundY = false;
 * 
 * for (int i = 0; i < size; i++) {
 * TreeNode node = queue.poll();
 * 
 * if (node.val == x) foundX = true;
 * if (node.val == y) foundY = true;
 * 
 * 
 * if (node.left != null && node.right != null) {
 * if ((node.left.val == x && node.right.val == y) || (node.left.val == y &&
 * node.right.val == x)) {
 * return false;
 * }
 * }
 * 
 * if (node.left != null) queue.add(node.left);
 * if (node.right != null) queue.add(node.right);
 * }
 * 
 * if (foundX && foundY) {
 * return true;
 * }
 * 
 * else if (foundX || foundY) {
 * return false;
 * }
 * }
 * return false;
 * 
 * }
 * }
 * 
 */