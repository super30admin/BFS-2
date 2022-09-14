// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Cousins are the children that are on the same level(depth) and have different parent roots.
 * In the bfs approach, we will maintain a queue and at every point we will maintain a check for x and y , whether they are nodes
 * we are looking for and then make checks if they are on same level and have same parents or not. We will making these checks
 * after finishing each level traversal.
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
class Problem2 {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);


        while(!q.isEmpty()){

            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;

            //start bfs, going level by level
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                //if find x and y
                if(curr.val == x) x_found = true;
                if(curr.val ==y ) y_found = true;

                //check if they have same parent
                if(curr.left!=null && curr.right!=null){

                    if(curr.left.val == x && curr.right.val == y) return false;
                    if(curr.left.val == y && curr.right.val == x) return false;

                }

                //adding to queue
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);

            }
            //if both found
            if(x_found && y_found) return true;

            if(x_found || y_found) return false;
        }
        return false;
    }
}
