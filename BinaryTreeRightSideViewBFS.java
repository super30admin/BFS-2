// Time Complexity :O(N)
// Space Complexity :O(1) Correct me if I'm wrong as not storing the entire level
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideViewBFS {
    public List<Integer> rightSideView(TreeNode root) {
        //Unoptimized
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();

                if(current.left != null){
                    queue.add(current.left);
                }

                if(current.right != null){
                    queue.add(current.right);
                }

                if(i == size - 1){
                    result.add(current.val);
                }
            }
        }

        return result;
    }
}
