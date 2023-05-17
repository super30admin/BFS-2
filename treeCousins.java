//Time Complexity: O(n)
//Space Complexity: O(n)

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
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean found;

        while(!q.isEmpty()) {
            found = false;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.val == x || curr.val == y) {
                    if(found == false) {
                        found = true;
                    }
                    else {
                        return true;
                    }
                }

                if(curr.left != null && curr.right != null) {
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) {
                        return false;
                    }
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }

            if(found == true) {
                return false;
            }
        }

        return false;
    }
}