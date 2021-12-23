# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque
# Time Complexity O(n)
# Space Complexity is O(n)
# All test cases passed in leetcode

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        self.result = []
        self.BFS(root, 0)
        return self.result

    def BFS(self, root, lvl):
        # base condition
        if root is None:
            return

        # logic
        if len(self.result) == lvl:
            self.result.append(root.val)

        self.BFS(root.right, lvl + 1)
        self.BFS(root.left, lvl + 1)


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        self.result = deque()
        self.BFS(root, 0)
        return self.result

    def BFS(self, root, lvl):
        # base condition
        if root is None:
            return

        # logic
        if len(self.result) == lvl:
            self.result.append(root.val)
        else:
            self.result[lvl] = root.val

        self.BFS(root.left, lvl + 1)
        self.BFS(root.right, lvl + 1)


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if root is None:
            return []
        self.result = deque()
        self.queue = deque()
        self.levelqueue = deque()
        self.queue.append(root)
        self.levelqueue.append(0)

        while self.queue:
            root = self.queue.popleft()
            levelValue = self.levelqueue.popleft()

            if len(self.result) == levelValue:
                self.result.append(root.val)
            else:
                self.result[levelValue] = root.val

            if root.left:
                self.queue.append(root.left)
                self.levelqueue.append(levelValue + 1)
            if root.right:
                self.queue.append(root.right)
                self.levelqueue.append(levelValue + 1)

        return self.result
