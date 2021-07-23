//TC: O(N)
//SC: O(N)
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
class Solution {
    TreeNode xParent, yParent;
    boolean xFound, yFound;
    int xLevel, yLevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y)
            return false;
        
        dfs(root, 0, null, x, y);
        return xLevel == yLevel && xParent != yParent;
        
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
        
//         boolean xFound = false, yFound = false;
        
//         while(!queue.isEmpty()) {
//             int sz = queue.size();
            
//             for(int i=0; i<sz; i++) {
//                 TreeNode curr = queue.poll();
                
//                 if(curr.val == x) xFound = true;
//                 if(curr.val == y) yFound = true;
                
//                 if(curr.left != null && curr.right != null) {
//                     int val1 = curr.left.val;
//                     int val2 = curr.right.val;
//                     if((val1 == x && y == val2) || (val1 == y && x == val2)) return false;
//                 }
                
//                 if(curr.left != null) queue.add(curr.left);
//                 if(curr.right != null) queue.add(curr.right);
                
//             }
            
//             if(xFound && yFound) return true;
//             if(xFound || yFound) return false;
//         }
        
//         return false;
    }
    
    private void dfs(TreeNode root, int level, TreeNode parent, int x, int y) {
        
        if(root == null) return;
        if(xFound && yFound) return;
        
        if(root.val == x) {
            xLevel = level;
            xFound = true;
            xParent = parent;
        }
        if(root.val == y) {
            yLevel = level;
            yFound = true;
            yParent = parent;
        }
        
        dfs(root.left, level+1, root, x, y);
        dfs(root.right, level+1, root, x, y);
    }
}





