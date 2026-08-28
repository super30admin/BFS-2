#Time Complexity: O(n)
#Space Complexity: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        """self.result = []
        self.helper(root, 0)
        return self.result

    def helper(self, root, level):
        if root is None: return
        if level == len(self.result): self.result.append(root.val)
        self.helper(root.right, level + 1)
        self.helper(root.left, level + 1)"""
        result = []
        if root is None: return result

        q = deque()
        q.append(root)

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i == size - 1: result.append(curr.val)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)

        return result
        