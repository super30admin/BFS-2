import java.util.Queue;
import java.util.*;


//BFS: Using Queue level order traversal. Based on the queue size, we can iterate. In that if we can take only the last element it would be the right side visible element. 
//DFS: Using iterative pre order, Each deapth for the first time we are adding the node to  the result list. In that we only add right side elements.

//TC: O(N) where N is the height of the tree, since we travers through all the elements.
//SC: O(N) - Since we are using Queue for the auxilary purposes. ( can ignore the list as that is what function expects back)
class BinaryTreeRightSideView_993 {
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>(); 
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode currentNode = queue.poll();
                if(i == size-1) { // Gets always right element. //1 - 0 th element, 4 - 3rd element.
                    result.add(currentNode.val);
                }
                if(currentNode.left!=null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return result;
    }


    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView_993 binaryTreeRightSideView_993 = new BinaryTreeRightSideView_993();
        TreeNode root = new TreeNode().getSampleFour();
        //final List<Integer> result = binaryTreeRightSideView_993.rightSideViewBFS(root);
        final List<Integer> result = binaryTreeRightSideView_993.rightSideViewDFS(root);
        System.out.println("The given nodes are cousins:" + result);
    }
}