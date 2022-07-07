'''
Time Complexity: O(n)
Space Complexity: O(n)
Run on Leetcode: YES
'''
from collections import deque
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not (root.right and root.left):
            return False
        queue = deque()
        queue.append(root)
        while(len(queue) != 0):
            size = len(queue)
            xFlag = False
            yFlag = False
            for _ in range(size):
                curr = queue.popleft()
                if curr.val == x:
                    xFlag = True
                if curr.val == y:
                    yFlag = True
                if curr.left and curr.right:
                    if (curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x):
                        return False
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if xFlag and yFlag:
                return True
            if xFlag or yFlag:
                return False