"""
Time Complexity : O(n) n is number of nodes
Space Complexity : O(H) H is height of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        self.result = []
        self.dfs(root, 0)
        return self.result
    def dfs(self, root, level):
        # Base
        if not root:
            return
        # Logic
        if level == len(self.result):
            self.result.append(root.val)
        # Go right first as we are looking at the right side
        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)
            