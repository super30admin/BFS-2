# Time complexity - O(n)
# Space complexity - O(h)

# Approach - DFS - Maintain x and y's parents and heights. Once dfs is done, return True if both conditions met.

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False
        self.x_parent = None
        self.y_parent = None
        self.x_h = 0
        self.y_h = 0

        self.dfs(root, None, 0, x, y)
        return self.x_parent != self.y_parent and self.x_h == self.y_h

    def dfs(self, root: Optional[TreeNode], parent: Optional[TreeNode], lvl: int, x: int, y: int) -> None:
        # base
        if root == None:
            return

        # logic
        if root.val == x:
            self.x_parent = parent
            self.x_h = lvl
            return
        
        if root.val == y:
            self.y_parent = parent
            self.y_h = lvl
            return

        self.dfs(root.left, root, lvl+1, x, y)
        self.dfs(root.right, root, lvl+1, x, y)