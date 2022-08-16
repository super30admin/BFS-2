// Time Complexity : O(n) where n = number of elements in the tree
// Space Complexity : O(n) where n = width of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//993. Cousins in Binary Tree (Easy) - https://leetcode.com/problems/cousins-in-binary-tree/
class Solution {
    
	// Time Complexity = O(n) where n = number of elements in tree, Space Complexity : O(h) where h = height of the tree
//    TreeNode xParent;
//    TreeNode yParent;
//    int xLevel, yLevel;
//    
//    public boolean isCousins(TreeNode root, int x, int y) {
//        if (root == null) return false;
//        dfs(root, x, y, 0, null);
//        return (xLevel == yLevel) && (xParent != yParent);
//    }
//    
//    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
//        // base
//        if (root == null) return;
//        
//        // logic
//        if (root.val == x) {
//            xLevel = level;
//            xParent = parent;
//        }
//        
//        if (root.val == y) {
//            yLevel = level;
//            yParent = parent;
//        }
//        
//        dfs(root.left, x, y, level + 1, root);
//        dfs(root.right, x, y, level + 1, root);
	
	if (root == null) return false;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        boolean xFound = false;
        boolean yFound = false;
        
        for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            
            if (curr.val == x) xFound = true;
            if (curr.val == y) yFound = true;
            
            if (curr.left != null && curr.right != null) {
                if ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) {
                  return false;  
                }
            }
            
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        
        if (xFound && yFound) return true;
    }
    
    return false;
    }
}