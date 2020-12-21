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

/**
 * Time Complexity = O(N) where N is the number of nodes in the tree
 * Space Complexity = O(N) where N is the number of nodes in the binary tree
 * LeetCode: Y (https://leetcode.com/problems/binary-tree-right-side-view/)
 * Approach: 
    Do a BFS level-order traversal and at each level add the last val to the result after a level is processed
    Do the BFS level-wise using the size of each level
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // initialize result arraylist 
        List<Integer> rightView = new ArrayList<>();
        
        // check edge case
        if(root == null) {
            return rightView;
        }
        
        // initalize queue
        Queue<TreeNode> q = new LinkedList<>();
        
        // enqueue root
        q.add(root);
        
        // loop until the q is empty i.e. entire tree is traversed
        while(!q.isEmpty()) {
            // get current level size
            int size = q.size();
            // initalize variable to track the node last seen
            int nodeValLastSeen = q.peek().val;
            
            // loop through the current level
            while(size-- > 0) {
                // remove the node at the front of the queue
                TreeNode currentNode = q.poll();
                
                // update the last seen node val
                nodeValLastSeen = (size == 0 ? currentNode.val : nodeValLastSeen);
                
                // if there is valid left child of current node then enqueue the left child
                if(currentNode.left != null) {
                    q.add(currentNode.left);
                }
                
                // if there is valid right child of current node then enqueue the right child
                if(currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
            
            // finally add the righmost node val i.e. last seen node val at level to the result arraylist
            rightView.add(nodeValLastSeen);
        }
        
        // return result
        return rightView;
    }
}
