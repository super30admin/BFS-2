# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
      
        # if tree is empty is there, then return False
        if not root:
            return False
        
        # add root to the queue
        q = deque([root])
        
        # traversing until queue is not empty
        while q:
            # getting the size of the queue as we will go over all the elements of the queue
            size = len(q)
            
            # initially we define the bool of x and y found as false
            x_found = False
            y_found = False
            
            # going over all the elements of the queue, pop the element and check if that element is x or y
            for i in range(size):
                curr = q.popleft()
                
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                
                # check if x and y values are children of current nodes, if they have the same parent, then return False
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                # if any children is there, append it to the queue, same for right
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
             
            # if at the end, we find both the elements then return True, if either one is found, then return False
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        return False
