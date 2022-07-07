'''
Time Complexity: O(n)
Space Complexity: O(h)
Run on Leetcode: YES
'''
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def dfs(self, root: Optional[TreeNode], result: list[int], lvl: int) -> None:
        #base
        if not root:
            return
        #logic
        if lvl == len(result):
            result.append(root.val)
        else:
            result[lvl] = root.val
        self.dfs(root.left,result,lvl + 1)
        self.dfs(root.right,result,lvl + 1)
        
    def rightSideView(self, root: Optional[TreeNode]) -> list[int]:
        if not root:
            return []
        result = []
        self.dfs(root, result, 0)
        return result