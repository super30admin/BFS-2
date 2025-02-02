# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False
        x_found = False
        y_found = False
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
            if x_found == True and y_found == True:
                return True
            if  x_found == True or y_found == True:
                return False
        return False
"""
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False

        x_level = -1
        y_level = -1
        x_parent = None
        y_parent = None

        def dfs(node, parent, level, x, y):
            nonlocal x_level, y_level, x_parent, y_parent  # Needed to modify outer variables
            if node is None:
                return
            
            if node.val == x:
                x_parent = parent
                x_level = level
            elif node.val == y:
                y_parent = parent
                y_level = level
            
            dfs(node.left, node, level + 1, x, y)
            dfs(node.right, node, level + 1, x, y)

        dfs(root, None, 0, x, y)
        
        return (x_level == y_level) and (x_parent != y_parent)
"""
