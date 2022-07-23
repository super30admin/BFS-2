"""
Runtime Complexity:
O(n)- where 'n' is the number of nodes. We traverse through every node in tree.
Space Complexity: 
O(h) - stack space is the depth of the tree.
Yes, the code worked on leetcode.
Issues while coding- No
"""

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = TreeNode()
        self.y_parent = TreeNode()
    
        if root == None or x==y:
            return False
        
        self.dfs(root, 0, None, x, y)
        return (self.x_depth == self.y_depth and self.x_parent!=self.y_parent)
            
        
        
    def dfs(self,root,level, parent, x, y):
        if root == None:
            return
        if root.val == x:
            self.x_depth = level
            self.x_parent = parent
        if root.val == y:
            self.y_depth = level
            self.y_parent = parent
        
        self.dfs(root.left, level +1, root, x , y)
        self.dfs(root.right, level+1,root, x, y)
        
        