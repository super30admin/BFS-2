# Time Complexity : O(n) where n : number of nodes
# Space Complexity : O(h) where h : height of tree

# Definition for a binary tree node.

from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        result = []
        max_depth = -1

        def dfs(node, depth):
            nonlocal max_depth
            if not node:
                return

            # check if the current node is visible from the right side
            if depth > max_depth:
                result.append(node.val)
                max_depth = depth

            # traverse the right subtree
            dfs(node.right, depth+1)

            # traverse the left subtree
            dfs(node.left, depth+1)

        dfs(root, 0)
        return result
