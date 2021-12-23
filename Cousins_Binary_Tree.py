# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # Time Complexity O(n)
    # Space Complexity is O(n)
    # All test cases passed in leetcode
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if root is None:
            return False
        if (root.left == x and root.right == y) or (root.right == x and root.left == y):
            return False
        self.x_parent, self.y_parent = None, None
        self.x_level, self.y_level = 0, 0

        self.dfs(root, x, y, 0, None)
        return self.x_parent != self.y_parent and self.x_level == self.y_level

    def dfs(self, root, x, y, level, parent):
        if root is None:
            return

        if root.val == x:
            self.x_parent = parent
            self.x_level = level
        if root.val == y:
            self.y_parent = parent
            self.y_level = level

        self.dfs(root.left, x, y, level + 1, root)
        self.dfs(root.right, x, y, level + 1, root)
