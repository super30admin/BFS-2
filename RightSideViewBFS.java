import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

// BFS (width wise)
// Approach - 
// 1. Take all the nodes in the queue.
// 2. But only put the elements in result list, the last element in that level.
// 3. Level is determined by the size
// Time complexity = O(n)
// Space complexity = O(n) 
class RightSideBFS {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size(); // determines level.
            for(int i=0;i< size;i++) {
                TreeNode node = queue.poll();
                // add the node in the list, the last element of that level.
                if(i==size-1) {
                    res.add(node.val);
                }
                // put all the nodes in the queue.
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
        
    }
}