// Time Complexity : O(N) 
// Space Complexity : O(1) but the stack height is equal to the height of the tree    
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Perform DFS on the tree and find the X elemenet.
2. Once found store the level it's at and the parent element in global variables.
3. Perform DFS on the tree and find the Y elemenet.
4. Once found store the level it's at and the parent element in global variables.
5. If X and Y are the same level and have differnet parents, then they are cousin's
*/

// Your code here along with comments explaining your approach

class Solution {
    int levelx;
    int levely;
    TreeNode parentx;
    TreeNode parenty;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, null, 1);
        
        if(levelx == levely && parentx != parenty) return true;
        
        return false;
    }
    
    public void dfs(TreeNode root, int x, int y, TreeNode parent, int level) {
        if(root.val == x) {
            levelx = level;
            parentx = parent;
        }
        
        if(root.val == y) {
            levely = level;
            parenty = parent;
        }
        
        if(root.left!=null) dfs(root.left, x, y, root, level+1);
        if(root.right!=null) dfs(root.right, x, y, root, level+1);
    }
}
