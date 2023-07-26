// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//BFS

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

        //Pointer to store parents of x and y when found
        TreeNode xpar = null;
        TreeNode ypar = null;

        //Variable to store the depth of x and y
        int xdepth = 0 ;
        int ydepth = 0;

        //queue for BFS approach. Queue to store nodes, its parents and its depths
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qpar = new LinkedList<>();
        Queue<Integer> qdepth = new LinkedList<>();

        //Adding first root in the queue
        q.add(root);
        qpar.add(null);
        qdepth.add(1);

        //Loop will run till we go over all the elements
        while(q.peek() != null){
            //Get the node in the queue
            TreeNode node = q.remove();
            int depth = qdepth.remove();

            //Check if the node matches x or y and if it does then store the depth and it's parent
            if(node.val == x){
                xpar = qpar.remove();
                xdepth = depth;
            }
            else if(node.val == y){
                ypar = qpar.remove();
                ydepth = depth;
            } else{
                qpar.remove();
            }

            //Insert the node.left and node.right in queue
            if(node.left != null){
                q.add(node.left);
                qpar.add(node);
                qdepth.add(depth+1);
            } 
            if(node.right != null){
                q.add(node.right);
                qpar.add(node);
                qdepth.add(depth+1);
            } 

            //If we find both x and y, then compare it's parent and depth
            if(xpar != null && ypar != null){
                if(xpar.val == ypar.val) return false;
                if(xdepth != ydepth) return false;
                else return true;
            }
            
        }
        return false;
        
    }
}