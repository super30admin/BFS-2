# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def isCousins(self, root, x, y):
        q = deque()
        q.append(root)
        x_parent, y_parent = None, None
        while q:
            size = len(q)
            for _ in range(size):
                front = q.popleft()

                if front.left:
                    if front.left.val == x:
                        x_parent = front
                    if front.left.val == y:
                        y_parent = front
                    q.append(front.left)
                if front.right:
                    if front.right.val == y:
                        y_parent = front
                    if front.right.val == x:
                        x_parent = front
                    q.append(front.right)

            if x_parent and y_parent:
                return not (x_parent == y_parent)

            if x_parent or y_parent:
                return False

        return False
