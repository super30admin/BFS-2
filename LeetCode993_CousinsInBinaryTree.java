import java.util.Queue;

import javax.swing.tree.TreeNode;

//approach -1
/*
 * 1. add root to the queue. 
 * 2.calculate size and run for loop till size 
 * 3.poll the node, and check if curr.value == x or if  curr.value == y
 * if so, set x or y true respectively.
 * 4. check if curr has left , and if it's value  equal to x && it's right  = y  ; then return false
 * 5. check if curr has left , and if it's value  equal to Y && it's right  = X  ; then return false
 * 6. if not , that means we have to process the children, so q.add(left), and same for right 
 * 7. at last - after the level traversal / for loop run till size is done, and we just found x but not Y or the other way
 * we return false. 
 * 8. if we find both in the same level , then it's true. 
 * 
*/

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
        
        if(root == null || x == y ) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            boolean xFound = false;
            boolean yFound = false;

            int size = q.size();
            for(int i=0; i< size; i++)
            {
                TreeNode curr = q.poll();
                //process the node
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;

                //process the children
                if(curr.left != null && curr.right != null && curr.left  == x && curr.right == y) return false;
                if(curr.left != null && curr.right != null && curr.left  == y && curr.right == x) return false;

                //otherwise addd children to the queue
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            //we are done processing one level check xfound and yfound
            if(xFound == true && yFound == true) return true;
            if(xFound == true || yFound == true) return false;
        }
        //at last we will never come here, but still return false here if we dont find x or y
        return false;
    }
}