# Time Complexity : O(n) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to track the parent and levels if levels same and parents different then return true.

class Solution:
    def __init__(self):
        x_n = TreeNode();
        y_n = TreeNode();
        x_d = 0;
        y_d = 0;
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        self.dfs(root, x,y,0 , None)
        return ((self.x_d == self.y_d) and (self.x_n != self.y_n))
    
    def dfs(self, root, x,y, level, prt):
        if(root == None):
            return
        
        if(root.val == x):
            self.x_d=level
            self.x_n=prt
        if(root.val == y):
            self.y_d=level
            self.y_n=prt        

        self.dfs(root.left, x, y, level+1, root)
        self.dfs(root.right, x, y, level+1, root)