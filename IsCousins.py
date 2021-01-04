'''
Time complexity O(N)
Space complexity Asymptotically O(N)
'''



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.x_found = False
        self.y_found = False
        self.x_parent = False
        self.y_parent = False
        
        
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        self.dfs(root, None, 0, x, y)
        
        return (self.x_found == self.y_found) and (self.x_parent != self.y_parent)
    
    def dfs(self, root, parent, depth, x, y):
        if not root:
            return
        
        if root.val == x:
            self.x_found = depth
            self.x_parent = parent
            
        if root.val == y:
            self.y_found = depth
            self.y_parent = parent
            
        self.dfs(root.left,  root.val, depth+1, x, y)
        self.dfs(root.right, root.val, depth+1, x, y)
        
        
        