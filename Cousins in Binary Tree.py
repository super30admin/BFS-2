""""// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# BFS-
from collections import deque


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            xFlag = False
            yFlag = False

            for i in range(size):
                curr = q.popleft()
                if curr.val == x:
                    xFlag = True
                if curr.val == y:
                    yFlag = True

                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left is not None:
                    q.append(curr.left)

                if curr.right is not None:
                    q.append(curr.right)

            if xFlag and yFlag:
                return True
            if xFlag or yFlag:
                return False
        return False


""""// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

# DFS-
class Solution:
    def __init__(self):
        self.xParent = None
        self.xHight = 0
        self.yParent = None
        self.yHight = 0

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False
        self.dfs(root, None, 0, x, y)
        return self.xParent != self.yParent and self.xHight == self.yHight

    def dfs(self, root, parent, level, x, y):

        if root is None:
            return

        if root.val == x:
            self.xParent = parent
            self.xHight = level

        if root.val == y:
            self.yParent = parent
            self.yHight = level

        self.dfs(root.left, root, level+1, x, y)
        self.dfs(root.right, root, level+1, x, y)
