/* https://leetcode.com/problems/cousins-in-binary-tree/
993. Cousins in Binary Tree - EASY
*/

import java.util.*;

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

public class Cousins {

    int levelX = -1, levelY = -1;
    TreeNode parentX = null, parentY = null;
    
    /*
    Traverse the tree recurseively to get the level of nodes with value X and Y, and set their parents
    Intially, both levelX and levelY is -1, as we find node, the level is updated
    Parent is set for both nodes through the recursive call
    If X and Y are at same level, with different parent, after the recursive call, they are cousins.

    TC: O(n) => all nodes in tree worst case
    SC: O(h) => height of tree for recursive stack, in worst case h can be n
    */
    public boolean isCousinsRecursive(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }      
        
        helper(root, x, y, null, 0);
        
        if (levelX == levelY && parentX != parentY) {
            return true;
        }
        return false;
    }
    
    private void helper(TreeNode root, int x, int y, TreeNode parent, int level) {
        if (root == null) {
            return;
        }
        
        if (root.val == x) {
            levelX = level;
            parentX = parent;
        } else if (root.val == y) {
            levelY = level;
            parentY = parent;
        }
        
        if (levelX != -1 && levelY != -1) {
            return;
        }
        
        helper(root.left, x, y, root, level+1);
        helper(root.right, x, y, root, level+1);
    }
    
    /*
    Appraoch: follow the natural definition of the problem and traverse the tree level wise
    (i) If both nodes have the same parent, return false (they are not cousins), this can be done while adding the children to the queue
    (ii) If at any level, both X and Y are present, they are cousins. When we reach here, we have already ruled out the possiblility
    that, they may be siblings, as that is checked at the time of adding nodes in the queue at step (1) 
    TC: O(n) => visit all nodes
    SC: O(n) => (2^h) => h: max height
    */
    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            boolean hasX = false, hasY = false;
            
            for (int i = 0; i < size; i++) {
                TreeNode n = q.remove();
                
                if (n.val == x) {
                    hasX = true;
                } else if (n.val == y) {
                    hasY = true;
                }
                
                if (n.left != null && n.right != null) {
                    if (n.left.val == x && n.right.val == y
                       || n.left.val == y && n.right.val == x) {
                        return false;
                    }
                }
                if (n.left != null) {
                    q.offer(n.left);
                }
                if (n.right != null) {
                    q.offer(n.right);
                }
            }
            
            if (hasX && hasY) {
                return true;
            }
        }
        
        return false;
    }
}