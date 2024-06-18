// Time Complexity : O(n) => As we iterate over the n nodes
// Space Complexity : O(n) => As we are storing the nodes in the queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach : Using BFS(Level Order Traversal). Take queue and add the root node. Run a while loop to check if queue is not empty and use size variable
to hold size of the queue. Then using for loop start iterating and check if both the left & right child are equal to x & y, return false as they have same parent.
After for loop ends if both x_found & y_found are true it indicates they are at same depth with diff parent, return true. If only one of them is true return false as it indicates diff depth.
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean x_found = false;
        boolean y_found = false;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if(curr.val == x){
                    x_found = true;
                }

                if(curr.val == y){
                    y_found = true;
                }

                if(curr.left != null && curr.right!=null){
                    if(curr.left.val == x && curr.right.val == y){
                        return false;
                    }
                }

                if(curr.left != null && curr.right!=null){
                    if(curr.left.val == y && curr.right.val == x){
                        return false;
                    }
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }

            }

            if(x_found == true && y_found == true){
                return true;
            }

            if(x_found == true || y_found == true){
                return false;
            }

        }

        return false;
    }
}