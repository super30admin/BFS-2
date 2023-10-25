# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        # Time: O(N)
        # Space: O(H)
        self.res = []

        def findDepth(root, parent, depth):
            if not root: return
            if root.val in (x, y): self.res.append((parent, depth))
            findDepth(root.left, root, depth + 1)
            findDepth(root.right, root, depth + 1)

        findDepth(root, None, 0)
        if self.res[0][0] != self.res[1][0] and self.res[0][1] == self.res[1][1]: return True
        return False
