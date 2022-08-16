# Time complexity : O(n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
      
        self.res = []
        if not root:
            return self.res
        self.dfs(root,0)
        return self.res
    
    def dfs(self, root, depth):
        if not root:
            return
        # if deoth is equal to the size of the result, then we append a new element to the res, which is the root.val
        if depth == len(self.res):
            self.res.append(root.val)
        # recursively call the root.right first and its right view and then left subtree
        self.dfs(root.right, depth + 1)
        self.dfs(root.left, depth + 1)
        
        return self.res
        
        
        
