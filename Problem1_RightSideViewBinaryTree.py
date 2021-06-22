'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 199. Binary Tree Right Side View
# Given the root of a binary tree, imagine yourself standing on the
#  right side of it, return the values of the nodes you can see ordered
#   from top to bottom.


# Very similar to level order traversal. Instead of adding the whole level order
# list, we are adding only the last element of the intermediate level order list
# at each level

#-----------------
# Time Complexity: 
#-----------------
# O(N) - Need to iterate over all elements once
#------------------
# Space Complexity: 
#------------------
# O(W): Max stack size is width of the tree = N/2 nodes (worst case)

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import collections
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        queue = collections.deque()
        if root:
            queue.append(root)
            while len(queue) > 0:
                size = len(queue)
                level_order = []
                for i in range(size):
                    
                    curr = queue.popleft()
                    level_order.append(curr.val)
                    if curr.left:
                        queue.append(curr.left)
                    if curr.right:
                        queue.append(curr.right)
                result.append(level_order[-1])
        
        return result