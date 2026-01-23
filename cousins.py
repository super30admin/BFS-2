"""
time - o(n)
space - o(n)

we do bfs, we start with the root node and add it to the queue along with the root's current level (0) and parent (none)
for every node we pop, we check if its value is x or y, if it is, we note the level and parent. Once we find all the information
we compare and return true or false
"""
from typing import Optional
from collections import deque

# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append((root, None, 0))
        x_level = y_level = None
        x_parent = y_parent = None
        while q:
            node, parent, level  = q.popleft()
            if node.val == x:
                x_level = level
                x_parent = parent
            if node.val == y:
                y_level = level
                y_parent = parent
            if x_level and y_level and x_parent and y_parent:
                if x_level == y_level and x_parent!=y_parent:
                    return True
                else:
                    return False
            if node.left:
                q.append((node.left, node, level+1))
            if node.right:
                q.append((node.right, node, level+1))
        
        return False

        