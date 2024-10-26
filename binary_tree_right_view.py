# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        if root is None:
            return []
        q = deque([root])

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i == size - 1:
                    res.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
        return res


# time complexity is O(n)
# space complexity is O(n/2)
