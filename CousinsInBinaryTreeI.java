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
 * Time Complexity = O(N) where N is the number of nodes in the binary tree
 * Space Complexity = O(N) where N is the number of nodes in the binary tree
 * LeetCode: Y (https://leetcode.com/problems/cousins-in-binary-tree/)
 * Approach:
    Do a BFS level order traversal
    check if x and y are at same level
    check if x and y have the same parent node
    if x and y are at the same level and don't have a parent node then return true else return false
 */

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // variables to track presence of x and y at current level, and if x and y are siblings
        boolean isXPresentAtCurrentLevel = false, isYPresentAtCurrentLevel = false, areXAndYSiblings = false;
        
        // check edge case
        if(root == null) {
            return false;
        }
        
        // initalize queue
        Queue<TreeNode> q = new LinkedList<>();
        
        // enqueue root
        q.add(root);
        
        // loop until the q is empty i.e. entire tree is traversed or find a valid or invalid condition
        while(!q.isEmpty()) {
            // get current level size
            int size = q.size();
            
            // reset isXPresentAtCurrentLevel to false
            isXPresentAtCurrentLevel = false; 
            
            // reset isYPresentAtCurrentLevel to false
            isYPresentAtCurrentLevel = false;
            
            // loop through the current level
            while(size-- > 0) {
                // remove the node at the front of the queue
                TreeNode currentNode = q.poll();
                
                // check if the currentNode val equals x
                isXPresentAtCurrentLevel = (currentNode.val == x ? true : isXPresentAtCurrentLevel);
                
                // check if the currentNode val equals y
                isYPresentAtCurrentLevel = (currentNode.val == y ? true : isYPresentAtCurrentLevel);
                
                // if the current node has valid left and right children then check if they are x and y
                // if they are x and y then they are siblings (children of same parent) so return false
                if(currentNode.left != null && currentNode.right != null && ((currentNode.left.val == x && currentNode.right.val == y) || (currentNode.left.val == y && currentNode.right.val == x))) {
                    areXAndYSiblings = true;
                    return false;
                }
                
                // if x and y are present at current level and they are not siblings then return true
                if(isXPresentAtCurrentLevel && isYPresentAtCurrentLevel && !areXAndYSiblings) {
                    return true;
                }
                
                // if there is valid left child of current node then enqueue the left child
                if(currentNode.left != null) {
                    q.add(currentNode.left);
                }
                
                // if there is valid right child of current node then enqueue the right child
                if(currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
        
        // return false
        return false;
    }
}
