# Time Complexity : BFS - O(n) 
# Space Complexity : BFS - O(n)
# Did this code successfully run on Leetcode : Yes
from typing import Optional, List
from collections import deque
# Definition for a binary tree node.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
#DFS
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        self.result = []
        
        self.dfs(root, 0)
        
        return self.result
    
    def dfs(self, root: Optional[TreeNode], lvl: int):
        if not root:
            return
        if lvl == len(self.result):
            self.result.append(root.val)
            
        self.dfs(root.right, lvl + 1)
        self.dfs(root.left, lvl + 1)


# # BFS
# class Solution:
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return []
#         res = []
        
#         q = deque()
#         q.append(root)
        
#         while(q):
#             size = len(q)
#             res.append(q[-1].val)
            
#             for i in range(size):
#                 curr = q.popleft()
                
#                 if curr.left:
#                     q.append(curr.left)
#                 if curr.right:
#                     q.append(curr.right)
#         return res