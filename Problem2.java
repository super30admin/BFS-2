//TC: O(n)
//SC: O(n)

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;


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
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> pq=new LinkedList<>();//parent Queue

        q.add(root);
        pq.add(null);
        while (!q.isEmpty()) {
            int size=q.size();
            boolean x_found=false;
            boolean y_found=false;
            TreeNode x_parent=null;
            TreeNode y_parent=null;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                TreeNode pCurr = pq.poll();
                if (curr.val == x) {
                    x_found = true;
                    x_parent = pCurr;
                }
                if (curr.val == y) {
                    y_found = true;
                    y_parent = pCurr;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                    pq.add(curr);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                    pq.add(curr);
                }

                
            }
            if (x_found && y_found ){
            return x_parent != y_parent;
        }
        if(x_found || y_found){return false;}

        }return false;
    }
    
}