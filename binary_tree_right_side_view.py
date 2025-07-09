# Time Complexity : O(n), where n is the number of nodes in the tree
# Space Complexity : O(n), for the queue used in BFS and result list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used Breadth-First Search (BFS) to traverse the tree level by level.
# At each level, I took the last node value as the rightmost visible node.
# I added that value to the result list and continued to the next level.

from collections import deque
from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        result = []
        queue = deque([root])  # I used a queue to perform BFS

        while queue:
            level_size = len(queue)
            for i in range(level_size):
                node = queue.popleft()

                # If it's the last node at the current level, I add it to result
                if i == level_size - 1:
                    result.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return result
