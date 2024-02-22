'''
TC: O(n)
SC: O(h)
'''
# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent, self.y_parent = None, None
        self.x_level, self.y_level = 0, 0

        def dfs(root, parent, level):
            if not root:
                return
            if root.val == x:
                self.x_parent = parent
                self.x_level = level
            elif root.val == y:
                self.y_parent = parent
                self.y_level = level
            if self.x_parent == None or self.y_parent == None:
                dfs(root.left, root, level+1)
            if self.x_parent == None or self.y_parent == None:
                dfs(root.right, root, level+1)
        dfs(root, None, 0)

        return self.x_parent!=self.y_parent and self.x_level==self.y_level