# Time Complexity : O(N) where N is the number of nodes in the binary tree
# Space Complexity : O(h) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using BFS to traverse the tree level by level. I am keeping track of the parent of each node by using a parallel queue.
# I am finding the nodes with values x and y and I have boolean flags to check if I found them at the current level.
# If I find both nodes at the same level, I check if their parents are different. If they are different, I return True.
# If I find only one of the nodes at the current level, I return False as they cannot be cousins.

from collections import deque
from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return []
        q = deque([root])
        pq = deque([None])
        while q:
            cx = False
            cy = False
            px = None
            py = None
            for _ in range(len(q)):
                cur = q.popleft()
                pcurr = pq.popleft()
                if cur.val == x:
                    cx = True
                    px = pcurr
                if cur.val == y:
                    cy = True
                    py = pcurr
                if cur.left:
                    q.append(cur.left)
                    pq.append(cur)
                if cur.right:
                    q.append(cur.right)
                    pq.append(cur)
            if cx and cy:
                return px != py
            if cx or cy:
                return False




        