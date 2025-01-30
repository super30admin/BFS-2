# Time complexity - O(n)
# Space complexity - O(n)

# Approach II - Breadth First Search - Inside while loop, get the size of the q, run a for loop, 
# if root is last element of q, append root.val to result. Keep going through root's left and right nodes.

from queue import Queue
from typing import Optional, List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        result = []
        q = Queue()
        q.put(root)

        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                if i == size - 1:
                    result.append(curr.val)
                if curr.left != None:
                    q.put(curr.left)
                if curr.right != None:
                    q.put(curr.right)
        return result