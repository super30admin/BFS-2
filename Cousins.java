import java.util.LinkedList;
import java.util.Queue;


// O(n) time, n is number of nodes in tree
// O(n) space, recursion stack

/*
**
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()){
            boolean siblings = false;
            boolean cousins = false;
            
            int depth = queue.size();
            
            for (int i = 0; i < depth; i++){
                TreeNode node = queue.remove(); // FIFO
                
                if (node == null){
                    siblings = false;
                }
                else{
                    if (node.val == x || node.val == y){
                        if (cousins == false){
                            siblings = true;
                            cousins = true;
                        }
                        else{
                            return !siblings; // not cousins
                        }
                    }
                
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    queue.add(null); // null marker for siblings
                }    
            }
            if (cousins) return false; // end of level, cousins is set to true, we have only found one node at this level
        }
        return false;
    }
}