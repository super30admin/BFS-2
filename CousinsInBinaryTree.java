/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach1: BFS
// I'll be using a queue and maintain the levels by keeping track of the queue size. Before adding children of the current node, I'll be checking if the left and right children are not x and y.
// If while processing a specific level, x and y are found, then they will be cousins.
/*
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // edge case check
        if(root == null) return false;
        // Queue to hold nodes level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // initial entry in queue
        // loop condition
        while(!queue.isEmpty()) {
            // size helps in processing queue entries level by level
            int size = queue.size();
            // these boolean values will be reset after processing each level
            boolean xFound = false, yFound = false;
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                if(xFound && yFound) return true; // return true if x and y are found on the same level
                if(curr.left != null && curr.right != null) {
                    if((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x))
                        return false;
                }
                if(curr.left!= null) queue.offer(curr.left);
                if(curr.right!= null) queue.offer(curr.right);
            }
        }
        return false;
    }
}
*/

// Time Complexity : O(n)
// Space Complexity : O(h); h - > height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Approach2: DFS
// While exploring each node, I will be maintaing the level and the node's parent value.
// The level needs to be the same and parent needs to be different for two nodes to be cousins.
class Solution {
    TreeNode xParent, yParent;
    int xLevel, yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        // edge case
        if(root == null) return false;
        // dfs function will explore the node by considering parent value and level
        return dfs(root, x, y, null, 0);
    }
    
    private boolean dfs(TreeNode root, int x, int y, TreeNode parent, int level) {
        if(root == null) return false;
        if(root.val == x) {
            xLevel = level;
            xParent = parent;
        }
        if(root.val == y) {
            yLevel = level;
            yParent = parent;
        }
        dfs(root.left, x, y, root, level+1);
        dfs(root.right, x, y, root, level+1);
        if(xParent != yParent && xLevel == yLevel) return true;
        return false;
    }
}

