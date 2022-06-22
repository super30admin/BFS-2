# Time Complexity: O(n)
# Space Complexity: O(1); auxillary, O(h); recursive stack space
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.xParent = None
        self.xHt = 0
        self.yParent = None
        self.yHt = 0
        
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False
        self.dfs(root, None, 0, x, y)
        return self.xParent != self.yParent and self.xHt == self.yHt
    
    def dfs(self, root, parent, level, x, y):
        
        if root is None:
            return
        
        if root.val == x:
            self.xParent = parent
            self.xHt = level
        
        if root.val == y:
            self.yParent = parent
            self.yHt = level
            
        self.dfs(root.left, root, level+1, x, y)
        self.dfs(root.right, root, level+1, x, y)
        
        
        
        
        
        
