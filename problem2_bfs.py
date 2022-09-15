"""
Time Complexity : O(n) where n is the total number of nodes in the tree
Space Complexity : O(n/2) = O(n) where n is the size of the queue. At a time, in worst case if tree is a complete binary tree, queue will have all the leaf elements 

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
Perform the level order traversal and check if x and y are present in that level.
If they are found at that particualar level (x and y) then check if there parents are not equal.
If they are not equal return True else return False.
Also, if any one of the element found (x or y) at a particular level return False.

Level of the tree can be determined using size of the queue.
"""
from queue import Queue
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = Queue()
        queue.put(root)
        
        while(queue.empty() != True):
            size = queue.qsize()
            x_found = False
            y_found = False
            
            for i in range(size):
                curr = queue.get()
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                
                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                
                if curr.left != None:
                    queue.put(curr.left)
                if curr.right != None:
                    queue.put(curr.right)
                    
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        return False