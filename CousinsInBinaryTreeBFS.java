// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTreeBFS {
    public boolean isCousins(TreeNode root, int x, int y) {
        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.val == x){
                    x_found = true;
                }

                if(current.val == y){
                    y_found = true;
                }

                if(current.left != null && current.right != null){

                    //Same parent 2 condition
                    if(current.left.val == x && current.right.val == y){
                        return false;
                    }
                    if(current.left.val == y && current.right.val == x){
                        return false;
                    }
                }
                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }
            }
            if(x_found && y_found){
                return true;
            } // Both found and both at same level

            if(x_found || y_found){
                return false;
            }// One of them found at this level so one will be found at another level
            // So not cousins
        }
        return false; // does not matter control will not come till here
    }
}
