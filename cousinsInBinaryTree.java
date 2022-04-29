/**
problem: https://leetcode.com/problems/cousins-in-binary-tree/
*/

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
Approach 1: DFS
TC: O(n)
SC: O(H) wher H is the height of the tree
*/
class Solution {
    int parentX, parentY, heightX, heightY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        
        parentX = -1; parentY = -1;
        heightX = -1; heightY = -1;
        return isCousins(root, x, y, 0, null);
    }
    
    private boolean isCousins(TreeNode root, int x, int y, int height, TreeNode parent) {
        if (root == null) {
            return false;
        }
        
        if (root.val == x) {
            parentX = parent.val;
            heightX = height;
            
            if (parentY != -1 && parentY != parentX && heightX == heightY) {
                return true;
            }
        }
        
        if (root.val == y) {
            parentY = parent.val;
            heightY = height;
            
            if (parentX != -1 && parentY != parentX && heightX == heightY) {
                return true;
            }
        }
        
        return isCousins(root.left, x, y, height + 1, root) || isCousins(root.right, x, y, height + 1, root);
    }
}

/**
Approach 2: BFS
TC: O(n)
SC: O(n)
*/
class Solution {
    TreeNode parentX, parentY;
    int levelX, levelY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                
                if (node.val == x) {
                    foundX = true;
                } else if (node.val == y) {
                    foundY = true;
                }
                
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            if (foundX && foundY) {
                return true;
            }
            
            if (foundX || foundY) {
                return false;
            }
        }
        return false;
        
    }
}