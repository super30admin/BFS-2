# Time Complexity : O(n)
# Space Complexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        
        # global variables to store the parent and depth of x and y
        self.x_parent = self.y_parent = TreeNode(0)
        self.x_depth = self.y_depth = 0
        
        # call dfs with the root and 0 depth
        self.dfs(root, x, y, 0, None)
        
        # check if the depth is same for both the elements and they do not have same parent
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent
    
    def dfs(self, root, x, y, depth, parent):
        if not root:
            return 
        
        # check if root value is x, if so then assign the parent and the depth
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
        # check if root value is y, if so then assign the parent and the depth
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth
        
        # recursively call the dfs on left and right subtree while increasing the depth by 1
        self.dfs(root.left, x, y, depth+1, root)
        self.dfs(root.right, x, y, depth+1, root)
    
