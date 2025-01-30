# Time complexity - O(n)
# Space complexity - O(h)

# Approach II - Depth First Search - Do level order traversal, instead of maintaining list of elements at
# every level, replace the result[lvl] element with the latest one.

from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        self.result = []
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root: Optional[TreeNode], lvl: int) -> None:
        # base
        if root == None:
            return

        # logic
        if lvl == len(self.result):
            self.result.append(root.val)
        else:
            self.result[lvl] = root.val
        
        self.dfs(root.left, lvl + 1)
        self.dfs(root.right, lvl + 1)