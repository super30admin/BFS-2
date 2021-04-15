# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        q = Queue()
        q.put(root)
        x_found = False
        y_found = False
        while q.qsize():
            size = q.qsize()
            for i in range(size):
                node = q.get()
                if (node.left and node.right) and ((node.left.val == x and node.right.val == y) or node.left.val == y and node.right.val == x):
                    return False
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        return False
                
        