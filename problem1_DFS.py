#Time Complexity :O(N)
#Space Complexity :O(h)
#Did this code successfully run on Leetcode :yes
#Method: DFS

# Definition for a binary tree node.
from ast import List
import collections

class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right

class Solution:
    def rightSideView(self, root: [TreeNode]) -> List[int]:
        self.result = []
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root, level):
        if root is None:
            return
        
        if len(self.result) == level:
            self.result.append(root.val)
        else:
            self.result[level] = root.val
        
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)

          