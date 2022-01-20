# Time Complexity: O(n)
# Space Complexity: O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    x_depth = 0
    y_depth = 0
    x_parent = None
    y_parent = None
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        def dfs(root, x, y, level, parent):
            #BASE
            if not root: return
            #LOGIC
            if x == root.val:
                self.x_parent = parent
                self.x_depth = level
            if y == root.val:
                self.y_parent = parent
                self.y_depth = level
            parent = root
            dfs(root.left, x, y, level+1, parent)
            dfs(root.right, x, y, level+1, parent)
        if not root: return False
        dfs(root, x, y, 0, None)
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent