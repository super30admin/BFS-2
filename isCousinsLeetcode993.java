//Time Complexity: O(N)
//Space Complexity: O(N) //max width of the tree ..can be considered as O(N)
//Leetcode: Yes
import java.util.*;

public class isCousinsLeetcode993 {
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
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return true;
            }
            //tree si unique this will never happen
            if (x == y) {
                return false;
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            int level = 0;
            queue.add(root);

            while (!queue.isEmpty()) {
                level = queue.size();
                int index = 0;
                boolean foundOne = false;
                boolean sameParent = false;
                while (index < level) {
                    //we need to check the element at the same level only.
                    TreeNode node = queue.poll();
                    //if we found null that means any future node at this level will not have the same parent
                    if (node == null) {
                        sameParent = false;
                        index++;
                        continue;
                    }
                    if (x == node.val || y == node.val) {
                        //this is the first time one value matched.
                        if (!foundOne) {
                            foundOne = true;
                            sameParent = true;
                        } else {
                            //we need to check if they have same parent or not.
                            return (!sameParent);
                        }
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    queue.add(null);
                    index++;
                }
            }
            return false;
        }
    }
}
