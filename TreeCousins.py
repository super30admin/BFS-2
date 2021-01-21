# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


#Time = O(n)
#Space = O(h)

class Solution:
    
    def dfs(self, root, depth, parent, x, y):
        
        if not root:
            return
        
        if root.val == x:
            self.parent_x = parent
            self.height_x = depth
            
            
        if root.val == y:
            self.parent_y = parent
            self.height_y = depth
            
            
        self.dfs(root.left, depth+1, root, x, y)
        self.dfs(root.right, depth+1, root, x, y)
    
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.parent_x = None
        self.parent_y = None
        
        self.height_x = 0
        self.height_y = 0
        
        self.dfs(root, 0, None, x, y)
        
        return self.parent_x != self.parent_y and self.height_x == self.height_y
        
