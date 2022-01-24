# // Time Complexity : O(N)
# // Space Complexity :O(H)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    x_parent = TreeNode()
    y_parent = TreeNode()
    x_height = int()
    y_height = int()
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None: 
            return False
        self.dfs(root, None, 0, x,y)
        return (self.x_parent != self.y_parent and self.x_height == self.y_height)
    
    def dfs(self, root, parent, height,x,y):
        
        # base
        if root == None:
            return
        # logic
        if(x== root.val):
            self.x_parent = parent
            self.x_height = height
        if(y== root.val):
            self.y_parent = parent
            self.y_height = height
        
        self.dfs(root.left, root, height+1, x, y)
        self.dfs(root.right, root, height+1, x, y)
        
        
            
        
        
        