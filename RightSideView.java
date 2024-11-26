// Time complexity: O(n) Each node is visited once
// Space Complexity: O(d) where d is the width of the tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
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
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

       while(!queue.isEmpty()){
           int size = queue.size();

           for(int i=0; i<size; i++){
               TreeNode curr = queue.poll();
               if(i == size - 1){
                   result.add(curr.val);
               }

               if(curr.left !=null) queue.add(curr.left);
               if(curr.right !=null) queue.add(curr.right);
           }

       }
       return result;

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
