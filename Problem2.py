#993. Cousins in Binary Tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        x_found = y_found = False
        x_parent = y_parent = None

        q = deque([root])
        pq = deque([None])

        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                parent = pq.popleft()

                if curr.val == x:
                    x_found = True
                    x_parent = parent

                if curr.val == y:
                    y_found = True
                    y_parent = parent

                if curr.left:
                    q.append(curr.left)
                    pq.append(curr)

                if curr.right:
                    q.append(curr.right)
                    pq.append(curr)

        if x_found and y_found:
            return x_parent != y_parent
        if x_found or y_found:
            return False
        

        


        