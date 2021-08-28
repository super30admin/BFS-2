"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    depthX, depthY = 0, 0
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.root_x = root
        self.root_y = root
        if not root:
            return False
        self.dfs(root, x, y, 0, None)
        # If the parents are not equal and depth are equal then they are cousins
        if self.root_x != self.root_y and self.depthX == self.depthY:
            return True
        else:
            return False
    def dfs(self, root, x, y, depth, parent):
        #Base
        if not root:
            return
        # If we find x
        if root.val == x:
            self.root_x = parent
            self.depthX = depth
        #  If we find y
        if root.val == y:
            self.root_y = parent
            self.depthY = depth
        self.dfs(root.left, x, y, depth + 1, root)
        self.dfs(root.right, x, y, depth + 1, root)