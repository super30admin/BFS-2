'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 993. Cousins in Binary Tree
# In a binary tree, the root node is at depth 0, and children of each 
# depth k node are at depth k+1.

# Two nodes of a binary tree are cousins if they have the same depth, 
# but have different parents.

# We are given the root of a binary tree with unique values, and the 
# values x and y of two different nodes in the tree.

# Return true if and only if the nodes corresponding to the values x 
# and y are cousins.


#-----------------
# Time Complexity: 
#-----------------
# O(N) - Need to iterate over all elements once
#------------------
# Space Complexity: 
#------------------
# O(N): Max queue size is of the order O(N) since we are adding 
#      (W)N/2 + M elements in the worst case

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
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        level_order = []
        queue = collections.deque()
        result = False
        if root:
            queue.append(root)
            while len(queue) > 0:
                siblings = False
                cousins = False
                size = len(queue)
                for i in range(size):
                    curr = queue.popleft()
                    
                    if curr is None:
                        siblings = False
                    else:
                        if curr.val == x or curr.val == y:
                            if not cousins:
                                siblings = True
                                cousins = True
                            else:
                                return not siblings
                            

                        queue.append(curr.left)
                        queue.append(curr.right)
                        #Add none in the queue to denote the start of new siblings
                        queue.append(None)
                if cousins:
                    return False
                
            return False