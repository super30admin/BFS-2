// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, in finding the height of the node, i was using the
// generic height of the tree format but that didnt worked here as it gives the height from the leaft node,
// we cannot use those intermediate results here.

// Your code here along with comments explaining your approach
class Solution {
    TreeNode parentx;
    TreeNode parenty;
    int heightx;
    int heighty;
    public boolean isCousins(TreeNode root, int x, int y) {
        depth(root, x, y, 0);
        // System.out.println(parentx.val + "  " + parenty.val);
        return (parentx != parenty) && (heightx == heighty);
    }
    
    public void depth(TreeNode node, int x, int y, int lvl) {
        if(node == null)
            return;
        
        if(node.left != null) {
            if(node.left.val == x)
                parentx = node;
            if(node.left.val == y)
                parenty = node;
        }
        
        if(node.right != null) {
            if(node.right.val == x)
                parentx = node;
            if(node.right.val == y)
                parenty = node;
        }
        
        
        depth(node.left, x, y, lvl + 1);
        depth(node.right, x, y, lvl + 1);
                
        if(node.val == x)
            heightx = lvl;
        
        if(node.val == y)
            heighty = lvl;
        
        return;
    }
    
}