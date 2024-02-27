# https://leetcode.com/problems/binary-tree-right-side-view/description/

# Time Complexity : O(N) where N is number of nodes in a binary tree.
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach

# Approach : This is a BFS Solution, where I add every level in to a queue, and add the last element
# of the queue to the result.
# At the end we return the result.

from queue import Queue
from typing import List, Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []

        _queue = Queue()
        _queue.put(root)
        result = []

        while _queue.qsize() > 0:
            size = _queue.qsize()
            cur = None
            for index in range(size):
                cur = _queue.get()
                if cur.left is not None:
                    _queue.put(cur.left)
                if cur.right is not None:
                    _queue.put(cur.right)
            result.append(cur.val)

        return result
