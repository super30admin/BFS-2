"""
Problem: Binary Tree Right Side View
Approach: Do a BFS traversal and add the last element of the current level to the result.
t.c. => O(n)
s.c. => O(n)

"""
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return res

        q = deque()
        q.append(root)

        while q:
            parent = None
            for i in range(len(q)):
                parent = q.popleft()
                if parent.left:
                    q.append(parent.left)
                
                if parent.right:
                    q.append(parent.right)
            res.append(parent.val)
        return res



