/*
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root is None:
            return True
        
        self.x_parent = None
        self.y_parent = None
        self.x_level = None
        self.y_level = None
        
        self.dfs(root, None, 0, x, y)
        
        return self.x_parent != self.y_parent and self.x_level == self.y_level
    
    def dfs(self, root, parent, level, x, y):
        if root is None or (self.x_parent != None and self.y_parent != None):
            return
        
        if root.val == x:
            self.x_parent = parent
            self.x_level = level
        
        if root.val == y:
            self.y_parent = parent
            self.y_level = level
        
        self.dfs(root.left, root, level+1, x, y)
        self.dfs(root.right, root, level+1, x, y)
*/

// Time Complexity : O(N) where N is no of nodes in tree
// Space Complexity : O(h) where h is height of tree. WOrst case it would be equal to N
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Started from root I maintained info about level and parent in each recursive
// call and updated the same in the global variable


class Solution {
    TreeNode x_parent, y_parent;  // I chose this to be treenode instead of int as hypothetically if there would have been duplicates
    // then there might a case where two nodes parents are different but they have same value like x = 4 and y = 5 for below one
    //                      1
    //                  2       2        
    //                3    4  5   6

    int x_level, y_level;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return true;
        
        dfs(root, null, 0, x, y);
        return x_parent != y_parent && x_level == y_level;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if (root == null || (x_parent != null && y_parent != null))
            return;
        
        if (root.val == x){
            x_parent = parent;
            x_level = level;
        }
        
        if (root.val == y){
            y_parent = parent;
            y_level = level;
        }
        
        dfs(root.left, root, level+1, x, y);
        dfs(root.right, root, level+1, x, y);
    }
}