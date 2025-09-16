"""
TC: O(N) {we traverse each node once}
SC: O(W) {where W is the width of the binary tree. We store nodes at each level in the queue}

Approach:

We solve this problem using a Breadth-First Search (BFS) approach. We use a queue to process the tree level by level. At each level, we iterate through all the nodes in the current level. For each node, we check its children to see if they match `x` or `y`.

We maintain two flags, `has_x` and `has_y`, to track if we have found the nodes with values `x` and `y` within the current level. We also keep track of their parents, `parent_x` and `parent_y`.

After processing all nodes at a given level, we check our conditions. If both `x` and `y` were found (`has_x` and `has_y` are both `True`) and their parents are different (`parent_x != parent_y`), then they are cousins, and we return `True`. If one is found but not the other, they cannot be cousins (as they are on different levels), so we return `False`. If neither is found, we continue to the next level. If the loop completes and we haven't found them, they are not cousins.

The problem ran successfully on LeetCode.
"""

from collections import deque
from typing import List, Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([root])

        cousins = False

        while q:
            has_x, has_y = False, False
            parent_x, parent_y = None, None

            for i in range(len(q)):
                curr = q.popleft()

                if curr.left:

                    if curr.left.val == x:
                        has_x = True
                        parent_x = curr
                    if curr.left.val == y:
                        has_y = True
                        parent_y = curr

                    q.append(curr.left)

                if curr.right:

                    if curr.right.val == x:
                        has_x = True
                        parent_x = curr
                    if curr.right.val == y:
                        has_y = True
                        parent_y = curr

                    q.append(curr.right)

            if has_x and has_y and parent_x != parent_y:
                return True
            elif has_x or has_y:
                return False

        return cousins