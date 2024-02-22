'''
TC: O(n)
SC: O(h)
'''
# Definition for a binary tree node.
from typing import List, Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []

        def dfs(root, level):
            if not root:
                return
            if len(self.res) == level:
                self.res.append(root.val)
            dfs(root.right, level+1)
            dfs(root.left, level+1)

        dfs(root, 0)
        return self.res