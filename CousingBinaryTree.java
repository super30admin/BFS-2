// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * BFS Solution
 * Enqueue Node and its parent as a pair
 * When processing a node, check if the the nodes are found at the same level with their parent different
 * 
 * If at a certain level, one node is found and other is not, return false
 */

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<Pair<TreeNode,TreeNode>> q = new LinkedList<>();
        
        if (root.val == x || root.val == y) return false;
        
        if (root.left == null || root.right == null) return false;
        
        q.add(new Pair(root.left, root));
        q.add(new Pair(root.right, root));
        
        while (!q.isEmpty()) {
            int levelSize = q.size();
            
            boolean x_found = false;
            boolean y_found = false;
            
            TreeNode parent_x = null;
            TreeNode parent_y = null;
            
            for (int i=0;i<levelSize;i++) {
                Pair<TreeNode, TreeNode> currPair = q.poll();
                
                if (currPair.getKey().val == x) {
                    x_found = true;
                    parent_x = currPair.getValue();
                }
                
                if (currPair.getKey().val == y) {
                    y_found = true;
                    parent_y = currPair.getValue();
                }                
                
                if (currPair.getKey().left != null) {
                    q.add(new Pair(currPair.getKey().left, currPair.getKey()));
                }
                
                if (currPair.getKey().right != null) {
                    q.add(new Pair(currPair.getKey().right, currPair.getKey()));
                }
            }
            
            if (x_found && y_found) {
                if (parent_x == parent_y) {
                    return false;
                } else {
                    return true;
                }
            }
                
            if (x_found || y_found) {
                return false;
            }
        }
        
        return false;
    }
}


// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * DFS Solution
 * 
 * For every node, maintain a level on which it is present and the parent node
 * Maintain a level_x and level_y to store the level at which the two nodes are found
 * Also maintain two variables for parent_X and parent_Y
 * 
 * At the end of recursion, check if the conditions hold true for the cousins
 */

class Solution {
    
    TreeNode parent_x;
    TreeNode parent_y;
    
    int level_x;
    int level_y;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root.val == x || root.val == y) {
            return false;
        }
        
        if (root.left == null || root.right == null) {
            return false;
        }
        
        parent_x = null;
        parent_y = null;
        
        level_x = -1;
        level_y = -1;
        
        dfs(root.left, x, y, 1, root);
        dfs(root.right, x, y, 1, root);
        
        if (level_x == -1 || level_y == -1) {
            return false;
        }
        
        if (level_x != -1 && level_y != -1) {
            if (level_x != level_y) {
                return false;
            } else {
                if (parent_x == parent_y) return false;
            }
        }
        
        return true;
    }
    
    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        // base case
        if (root == null) return;
        
        // Logic
        // process root
        if (root.val == x) {
            parent_x = parent;
            level_x = level;
        }
        
        if (root.val == y) {
            parent_y = parent;
            level_y = level;
        }
        
        dfs(root.left, x, y, level+1, root);
        dfs(root.right, x, y, level+1, root);
    }
}