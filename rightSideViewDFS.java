import java.util.ArrayList;
import java.util.List;

public class rightSideViewDFS {
    public List<Integer> rightSideBinaryDFS(TreeNode root){
        List<Integer> result = new ArrayList<>();
        dfs( root, 0, result);
        return result;
        }

        public void dfs(TreeNode root, int depth, List<Integer> result){

        if(root == null) return;
        //
        if(depth == result.size()){
            result.add(root.val);
        }

        dfs(root.left, depth + 1, result);
        dfs(root.right,depth + 1, result);
    }

    public static void main (String [] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightSideView rightSideView = new RightSideView();

        // Getting the right side view of the binary tree
        List<Integer> result = rightSideView.rightSideView(root);

        // Printing the result
        System.out.println("Right Side View of the Binary Tree: " + result);
    }
}
