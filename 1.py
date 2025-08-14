'''
BFS-2

Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]: # type: ignore
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
