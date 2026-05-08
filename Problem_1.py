# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def rightSideView(self, root):
        self.result = []
        if not root:
            return self.result
        q = deque()
        q.append(root)
        while q:
            qsize = len(q)
            for idx in range(qsize):
                front = q.popleft()
                if idx == qsize - 1:
                    self.result.append(front.val)
                if front.left:
                    q.append(front.left)
                if front.right:
                    q.append(front.right)
        return self.result


'''

DFS Solution

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.dfs(root, 0)
        return self.result

    def dfs(self, root, level):
        if not root:
            return
        if level >= len(self.result):
            self.result.append(root.val)
        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)


'''