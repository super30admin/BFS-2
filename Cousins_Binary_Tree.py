'''
Time Complexity - O(n)
Space Complexity - O(h)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        self.x = x
        self.y = y
        self.x_parent = None
        self.y_parent = None
        self.x_depth = 0
        self.y_depth = 0
        self.helper(root, None, 0)
        if self.x_depth == self.y_depth and self.x_parent != self.y_parent:
            return True

    def helper(self, root, parent, depth):
        if not root:
            return
        if root.val == self.x:
            self.x_parent = parent
            self.x_depth = depth
        if root.val == self.y:
            self.y_parent = parent
            self.y_depth = depth
        self.helper(root.left, root, depth+1)
        self.helper(root.right, root, depth+1)
