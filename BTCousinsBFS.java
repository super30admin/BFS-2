//Time Complexity = O(N), where N is the number of nodes
//Space Complexity = O(D), where D is the diameter of the tree
//Did it run successfully on Leetcode: Yes

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
//if the nodes are of same depth and not have same parents, they are considered as cousins.
class BTCousinsBFS {
    boolean xFound = false, yFound = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        //base case
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int length = q.size();
            for(int i=0; i<length; i++) {
                TreeNode curr = q.poll();

                //if they are siblings, return false
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;
                }

                if(curr.val == x) {
                    xFound = true;
                }
                if(curr.val == y) {
                    yFound = true;
                }

                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            //if both values are found, return true
            if(xFound == true && yFound == true) return true;
            //if only one value is found at the same level, they are not cousins
            if(xFound == true || yFound == true) return false;
        }

        return false;
    }


}