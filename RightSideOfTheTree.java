import java.util.*;

public class RightSideOfTheTree {

    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size;i++) {
                TreeNode currentNode = queue.poll();
                if(i == size-1) {
                   result.add(currentNode.val); 
                }
                if(currentNode.left!=null) queue.add(currentNode.left);
                if(currentNode.right!=null) queue.add(currentNode.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RightSideOfTheTree rightSideOfTheTree = new RightSideOfTheTree();
        
        rightSideOfTheTree.rightSideView(root);
    }
}