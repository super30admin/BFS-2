# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:

        x_parent, y_parent = False, False
        x_level, y_level = 0, 0

        def recursion(node, parent, level):
            nonlocal x_parent, y_parent, x_level, y_level

            if not node:
                return

            if node.val == x:
                x_level = level
                x_parent = parent
            if node.val == y:
                y_level = level
                y_parent = parent

            recursion(node.left, node, level + 1)
            recursion(node.right, node, level + 1)

        recursion(root, None, 0)
        return x_parent != y_parent and x_level == y_level
