// =================================== DFS ====================================
/**
Time complexity: O(N)
Space complexity: O(H)
Algorithm:
=========
1. Perform DFS on the tree. keep track of depth and parent for every recursive call.
2. Update xParent, xDepth if x is found, Similarly yParent, yDepth if y is found
3. Return true if depths are same and parents are different. If not, return false
 */
class Solution {
    TreeNode xParent, yParent;
    int xDepth, yDepth; 
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root, x, y, 0, null);							// dfs to search for x and y
        return (xParent != yParent) && ( xDepth == yDepth );	// if parents are different and depths are same, return true;
    }
    
    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if(root == null) return;
        
        if(root.val == x) {						// Check if root value is equal to x, if so update depth and parent
            xParent = parent;
            xDepth = depth;
        }
        
        if(root.val == y) {						// Check if root value is equal to y, if so update depth and parent
            yParent = parent;
            yDepth = depth;
        }
        dfs(root.left, x, y, depth+1, root);		// recursively dfs for left subtree nodes
        dfs(root.right, x, y, depth+1, root);		// recursively dfs for right subtree nodes
    }
}

// =================================== BFS ====================================
/**
Time:O(N)
Space:O(N)
Algorithm:
=========
1. Use queue to add all nodes level by level. 
2. On each level, poll every node on that level from queue and check if its value is x or y, or if its children are x and y. 
3. If not, add left and right nodes to queue. 
4. By the end of a level, if both are found, then they are cousins. If only one of them is, they are not cousins due to unequal depth
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        //Queue for bfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        // flags to check if x and y are found
        boolean xFound = false, yFound = false;
        
        while( !q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {				// Traverse through current level and check for x and y
                TreeNode curr = q.poll();
                if(curr.val == x) xFound = true;
                if(curr.val == y) yFound = true;
                

                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y) //if children are x and y=> same parent, so return false
                        return false;
                    if(curr.left.val == y && curr.right.val == x) //if children are x and y=> same parent, so return false
                        return false;
                }
                
                if(curr.left != null) q.offer(curr.left);			// add left to queue 
                if(curr.right != null) q.offer(curr.right);			// add right to queue
            }
            
            if(xFound && yFound) return true;       //level already processed, both found => so cousins
            if(xFound || yFound) return false;      // level already processes, only one of them found => so not cousins
        }
        return false;
    }
}