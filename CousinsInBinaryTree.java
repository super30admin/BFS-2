import java.util.LinkedList;
import java.util.Queue;
//tc = o(n) visiting all nodes
// sc = o(n/2) => o(n) n/2 are the total leaf nodes
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            boolean x_found = false;
            boolean y_found = false;
            int size = q.size();
            for(int i = 0;i<size;i++){ // level by level check
                TreeNode current = q.remove();
                if(current.val == x){
                    x_found = true;
                }
                if(current.val == y){
                    y_found = true;
                }
                if(current.left != null && current.right != null){
                    if(current.left.val == x && current.right.val == y)return false;
                    if(current.right.val == x && current.left.val == y)return false;
                }
                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }

            }
            if(x_found && y_found)return true; // check this at all levels(imp)

        }
        return false;


    }
}