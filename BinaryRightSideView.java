// Time Complexity : O(n)
// Space Complexity : O(n/2) = O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.ArrayList;
import java.util.List;
public class BinaryRightSideView {

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
    private List<Integer> result;
    
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(result.size() == level) result.add(root.val);
        helper(root.right, level + 1);
        helper(root.left, level + 1);
    }
}



// public List<Integer> rightSideView(TreeNode root) {
//         result = new ArrayList<>();
//         if(root == null) return result;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         while(!queue.isEmpty()){
//             int size = queue.size();
//             for(int i = 0; i < size-1; i++){
//                 TreeNode node = queue.poll();
//                 if(node.left != null) queue.add(node.left);
//                 if(node.right != null) queue.add(node.right);
//             }
//             TreeNode node = queue.poll();
//             result.add(node.val);
//             if(node.left != null) queue.add(node.left);
//             if(node.right != null) queue.add(node.right);
//         }
//         return result;
// }