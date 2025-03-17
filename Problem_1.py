"""
## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
"""

from collections import deque
from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Solution class implementing two approaches to find the right-side view of a binary tree.
    """

    # ========================= 1. BFS (Iterative) Approach =========================
    # TC: O(N) - We traverse all nodes level by level.
    # SC: O(D) - Space for the queue, where D is the maximum width of the tree.
    def rightSideViewBFS(self, root: Optional[TreeNode]) -> List[int]:
        """
        Uses Breadth-First Search (BFS) to find the right-side view of a binary tree.
        The rightmost node at each level is added to the result.
        """
        if not root:
            return []

        result = []
        queue = deque([root])

        while queue:
            level_size = len(queue)

            for i in range(level_size):
                node = queue.popleft()

                # Capture the last node in the level (rightmost node)
                if i == level_size - 1:
                    result.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return result

    # ========================= 2. DFS (Recursive) Approach =========================
    # TC: O(N) - We traverse all nodes.
    # SC: O(H) - Recursive stack space, where H is the height of the tree.
    def rightSideViewDFS(self, root: Optional[TreeNode]) -> List[int]:
        """
        Uses Depth-First Search (DFS) to find the right-side view of a binary tree.
        Traverses the right subtree first to ensure rightmost nodes are seen first.
        """
        def dfs(node: Optional[TreeNode], level: int):
            if not node:
                return

            # If visiting this level for the first time, add the node's value
            if level == len(result):
                result.append(node.val)

            # Visit the right subtree first, then the left
            dfs(node.right, level + 1)
            dfs(node.left, level + 1)

        result = []
        dfs(root, 0)
        return result

