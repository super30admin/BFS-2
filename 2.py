'''
Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool: # type: ignore
        if root == None:
            return False

        self.x_parent = None
        self.y_parent = None
        self.x_h = 0
        self.y_h = 0
        self.dfs(root, 0, None, x, y)
        return self.x_parent != self.y_parent and self.x_h == self.y_h

    def dfs(self, root: Optional[TreeNode], lvl : int , parent: Optional[TreeNode], x, y): # type: ignore
        if root == None:
            return

        if root.val == x:
            self.x_parent = parent
            self.x_h = lvl
            return

        if root.val == y:
            self.y_parent = parent
            self.y_h = lvl
            return

        self.dfs(root.left, lvl+1, root, x, y)
        self.dfs(root.right, lvl+1, root, x, y)                    