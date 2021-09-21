# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

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
        if not root:
            return res
        q = deque([root])
        while q:
            temp = None
            for _ in range(len(q)):
                x = q.popleft()
                if x:
                    temp = x.val
                    q.append(x.left)
                    q.append(x.right)
            if temp is not None:
                res.append(temp)
        return res