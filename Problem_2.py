"""
## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)
"""
from collections import deque
from typing import Optional

# Definition for a binary tree node
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    """
    Solution class implementing three approaches to check if two nodes are cousins in a binary tree.
    """

    # ========================= 1. DFS (Recursive) Approach =========================
    # TC: O(N) - We traverse all nodes once.
    # SC: O(H) - Recursive stack space, where H is the height of the tree.
    def isCousinsDFS(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Uses Depth-First Search (DFS) to determine if two nodes are cousins.
        Two nodes are cousins if they are at the same depth but have different parents.
        """
        self.x_parent = self.y_parent = None
        self.x_level = self.y_level = 0

        self._dfs(root, x, y, 0, None)
        
        return self.x_parent != self.y_parent and self.x_level == self.y_level

    def _dfs(self, node: Optional[TreeNode], x: int, y: int, level: int, parent: Optional[TreeNode]):
        """
        Helper function for recursive DFS traversal.
        """
        if not node:
            return
        
        if node.val == x:
            self.x_parent, self.x_level = parent, level
        elif node.val == y:
            self.y_parent, self.y_level = parent, level

        # If both parents are found, stop recursion early
        if self.x_parent and self.y_parent:
            return
        
        self._dfs(node.left, x, y, level + 1, node)
        self._dfs(node.right, x, y, level + 1, node)

    # ========================= 2. BFS (Iterative) Approach =========================
    # TC: O(N) - We traverse all nodes level by level.
    # SC: O(W) - Space for the queue, where W is the maximum width of the tree.
    def isCousinsBFS(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Uses Breadth-First Search (BFS) to determine if two nodes are cousins.
        Two nodes are cousins if they are at the same depth but have different parents.
        """
        if not root:
            return False

        queue = deque([(root, None)])  # Store (node, parent)
        
        while queue:
            level_size = len(queue)
            x_parent = y_parent = None  # Reset parent info at each level

            for _ in range(level_size):
                node, parent = queue.popleft()

                if node.val == x:
                    x_parent = parent
                elif node.val == y:
                    y_parent = parent

                if node.left:
                    queue.append((node.left, node))
                if node.right:
                    queue.append((node.right, node))

            if x_parent and y_parent:
                return x_parent != y_parent  # True if they have different parents
            if x_parent or y_parent:
                return False  # If only one is found, they can't be cousins

        return False  # If loop exits without finding both nodes

    # ========================= 3. BFS (Iterative with Separate Parent Queue) =========================
    # TC: O(N) - We traverse all nodes level by level.
    # SC: O(2D) ≈ O(D) - Space for the queue, where D is the depth of the tree.
    def isCousinsBFSWithParentQueue(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Uses BFS with a separate parent queue to track the parent nodes at each level.
        This approach stores two separate queues: one for nodes and one for parents.
        """
        if not root:
            return False

        node_queue = deque([root])
        parent_queue = deque([None])  # Track parent nodes

        while node_queue:
            level_size = len(node_queue)
            x_parent = y_parent = None

            for _ in range(level_size):
                node = node_queue.popleft()
                parent = parent_queue.popleft()

                if node.val == x:
                    x_parent = parent
                elif node.val == y:
                    y_parent = parent

                if node.left:
                    node_queue.append(node.left)
                    parent_queue.append(node)
                if node.right:
                    node_queue.append(node.right)
                    parent_queue.append(node)

            if x_parent and y_parent:
                return x_parent != y_parent  # True if different parents
            if x_parent or y_parent:
                return False  # If only one is found, they can't be cousins

        return False  # If loop exits without finding both nodes
