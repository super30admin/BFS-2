# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# DFS
# Time Complexity : O(N)
# Space Complexity : O(h)
from typing import List


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        result = []

        def dfs(root, level):
            if root == None:
                return 
            if level == len(result):
                result.append(root.val)
            dfs(root.right, level+1)
            dfs(root.left, level+1)
            
        dfs(root, 0)
        return result
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# BFS
# Time Complexity : O()
# Space Complexity: O()
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        result = []
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if i == size -1:
                    result.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                     queue.append(curr.right)
        return result
"""