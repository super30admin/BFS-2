# Definition for a binary tree node.
"""BFS approach"""
#Accepted on Leetcode
#Time complexity - O(N) as we are visiting every node
#Space complexity - O(N) for the queue 


# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        queue = deque()
        #Edge case
        if root == None:
            return False
        queue.append(root)
              
        while len(queue)>0:
            size = len(queue)
            X_found = False
            Y_found = False
            for i in range(size):
                curr = queue.popleft()
                if curr.val == x:
                    X_found = True
                if curr.val == y:
                    Y_found = True
                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
            if X_found and Y_found:
                return True
        return False