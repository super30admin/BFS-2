import java.util.*;
//Time Complexity: O(N)
//Space Complexity: O(N)
//Leetcode: yes
public class RightSideViewofBT {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {

            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<Integer>();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            int level = 0;
            while (!queue.isEmpty()) {
                level = queue.size();
                int index = 0;
                while (index < level) {
                    TreeNode node = queue.poll();
                    if (index == 0) {
                        result.add(node.val);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    index++;
                }
            }
            return result;
        }
    }
}
