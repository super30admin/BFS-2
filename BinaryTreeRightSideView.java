import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeRightSideView {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(root, 0);
        return ans;

    }

    public void dfs(TreeNode node, int level) {
        if (node == null)
            return;
        if (level == ans.size()) {
            ans.add(node.val);
        }
        // if(node.right!=null){
        dfs(node.right, level + 1);
        // }
        // if(node.left!=null){
        dfs(node.left, level + 1);
        // }
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        // Create an instance of BinaryTreeRightSideView
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();

        // Call the rightSideView method and print the result
        List<Integer> result = binaryTreeRightSideView.rightSideView(root);
        System.out.println("Right Side View: " + result);
    }
}