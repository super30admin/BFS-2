import java.util.*;

public class RightSideOfTheTree {

    public List<Integer> rightSideViewBFS(TreeNode root) {
        //TC: O(N) - As we are traversing through all the elements
        //SC: O(N) - Worst case it will have all the elements in the queue.
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

    public List<Integer> rightSideViewDFS(TreeNode root) {
        //TC: O(N) - As we are traversing through all the elements
        //SC: O(H) - Worst case it will have height equalent elements in side the queue.
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        dfs(root, 0, result);
        return result; //As result is valud by reference in java, we don't need to keep it in the global scope.
    }

    private void dfs(TreeNode root, int height, List<Integer> result) {
        if(root == null) return;
        if(result.size() == height) {
            result.add(root.val);
        }
        dfs(root.right, height+1, result);
        dfs(root.left, height+1, result);
    }

    public static void main(String[] args) {
        RightSideOfTheTree rightSideOfTheTree = new RightSideOfTheTree();
        TreeNode sample = new TreeNode().getSampleFive();
        List<Integer>  result = rightSideOfTheTree.rightSideViewBFS(sample);
        System.out.println(result);
        
    }
}