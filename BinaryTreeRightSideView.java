
//TC will be O(n)
//SC will be O(n)


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i< size; i++){
                TreeNode curr = q.poll();
                if(i == size - 1){
                    result.add(curr.val);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return result;
    }


        public static void main(String[] args) {
            // Create a sample binary tree
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(5);
            root.right.right = new TreeNode(4);

            // Create an instance of BinaryTreeRightSideView
            BinaryTreeRightSideView solution = new BinaryTreeRightSideView();

            // Get the right side view of the binary tree
            List<Integer> rightSideView = solution.rightSideView(root);

            // Print the right side view
            System.out.println("Right Side View of the Binary Tree: " + rightSideView);
        }

}