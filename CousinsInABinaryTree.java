import java.util.LinkedList;
import java.util.Queue;

//Time Complexity: O(N) traversing through all nodes under worst case scenario
//Space Complexity: O(N) queue used as an auxiliary data structure
public class CousinsInABinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        // cousin mean they should not belong to the same parent for any subtrees

        if(root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int contains = 0;
            for(int i =0; i< size; i++){
                TreeNode currentNode = queue.poll();
                if((currentNode.val == x || currentNode.val == y)){
                    contains++;
                }
                if(currentNode.left != null && currentNode.right != null && ((currentNode.left.val == x && currentNode.right.val == y) ||(currentNode.left.val == y && currentNode.right.val == x))){
                    return false;
                }
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }

            }
            if(contains == 2){
                return true;
            }
            if(contains == 1){
                return false;
            }
            level++;
        }

        return false;

    }
}
