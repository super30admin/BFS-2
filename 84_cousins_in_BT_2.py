# Time complexity - O(n)
# Space complexity - O(n)

# Approach - BFS - Maintain two variables x_found and y_found, check if x and y are curr.left and curr.right
# or viceversa and put children into q. Finally when one level is complete, check if both x and y are found,
# if yes, return True, if either of one is found, return False. 

from typing import Optional
from queue import Queue
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False
        x_found = False
        y_found = False
        q = Queue()
        q.put(root)

        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left != None and curr.right != None:
                    if (curr.left.val == x and curr.right.val == y) or (curr.right.val == x and curr.left.val == y):
                        return False
                if curr.left != None:
                    q.put(curr.left)
                if curr.right != None:
                    q.put(curr.right)
            if x_found == True and y_found == True:
                return True
            if x_found == True or y_found == True:
                return False