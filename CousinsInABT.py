# Definition for a binary tree node.
from typing import Optional,List,Deque
import collections
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = collections.deque([root])
        #logic
        while q:
            size = len(q)
            xfound = False
            yfound = False
            for i in range(size):
                curr = q.popleft()
                if curr.val == x:
                    xfound = True
                if curr.val == y:
                    yfound = True
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y: return False
                    if curr.left.val == y and curr.right.val == x: return False
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if xfound and yfound: return True
            if xfound or yfound: return False
        return False


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
#         # idea is to maintain a parent and its child in bfs queue and match them for parents since level remains same
#         qp,q = deque([None]),deque([root])
#         #logic
#         while q:
#             size = len(q)
#             xfound = False
#             yfound = False
#             xp = None
#             yp = None
#             for i in range(size):
#                 curr = q.popleft()
#                 currp = qp.popleft()
#                 if curr.val == x:
#                     xfound = True
#                     xp = currp
#                 if curr.val == y:
#                     yfound = True
#                     yp = currp
#                 if curr.left:
#                     qp.append(curr)
#                     q.append(curr.left)
#                 if curr.right:
#                     qp.append(curr)
#                     q.append(curr.right)
#             if xfound and yfound:
#                 return xp != yp
#             if xfound or yfound : return False
#         return False


        

        