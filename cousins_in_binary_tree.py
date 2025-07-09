# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(n), for the queue used in level-order traversal
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used Breadth-First Search (BFS) to traverse the tree level by level.
# While traversing each level, I checked if both x and y were found at the same depth.
# I also made sure that x and y did not share the same parent.
# If both conditions were met, I returned True (they're cousins). Otherwise, False.

from collections import deque
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False

        queue = deque([(root, None)])  # (node, parent)

        while queue:
            level_size = len(queue)
            x_parent = y_parent = None

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

            # After each level
            if x_parent and y_parent:
                return x_parent != y_parent
            elif x_parent or y_parent:
                return False

        return False
