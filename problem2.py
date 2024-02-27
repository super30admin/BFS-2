# https://leetcode.com/problems/cousins-in-binary-tree/

# Time Complexity : O(N) where N is number of nodes in a binary tree.
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach

# Approach : This is a BFS Solution, where I add every level in to a queue, and check if both x and y
# are present in the same level or not. However, we need to check if they are not from same parent node
# So, while adding x and y to the queue I check them and then add them to the queue.

from queue import Queue
from typing import Optional


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        _queue = Queue()
        if root is None:
            return False
        _queue.put(root)
        found_x = False
        found_y = False
        while _queue.qsize() > 0:
            cur_size = _queue.qsize()
            for cur in range(cur_size):
                cur_node = _queue.get()
                if cur_node.val == x:
                    found_x = True
                if cur_node.val == y:
                    found_y = True
                if self.check_if_they_have_same_parent(cur_node, x, y):
                    return False
                if cur_node.left is not None:
                    _queue.put(cur_node.left)
                if cur_node.right is not None:
                    _queue.put(cur_node.right)
            if found_x and found_y:
                return True
            if (found_x and not found_y) or (not found_x and found_y):
                return False
        return False

    @classmethod
    def check_if_they_have_same_parent(cls, cur_node, x, y):
        if cur_node.left is None or cur_node.right is None:
            return False
        if cur_node.left.val == x and cur_node.right.val == y:
            return True
        if cur_node.left.val == y and cur_node.right.val == x:
            return True
        return False
