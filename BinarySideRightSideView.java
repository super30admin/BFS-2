
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//Time Complexity: O(N)
//Space Complexity : O(N)
public class BinarySideRightSideView {

    //Time Complexity: O(N) Traversing all nodes
    //Space complexity: O(N) worst case all nodes would be added to the queue
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rightView = new ArrayList<>();
        TreeNode currentNode = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                currentNode = queue.poll();
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
            rightView.add(currentNode.val);
        }
        return rightView;
    }
}
