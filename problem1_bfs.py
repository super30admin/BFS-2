"""
Time Complexity : O(n) where n is the total number of nodes in the tree
Space Complexity : O(n/2) = O(n) where n is the size of the queue. At a time, in worst case if tree is a complete binary tree, queue will have all the leaf elements 

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
#BFS approch
Perfrom the level order traversal and append the last element present at that particular level in the resultant array.
The number nodes present at a particular approach can be determine using size of the queue.
"""
from queue import Queue
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return None
        result = []
        queue = Queue()
        
        queue.put(root)
        
        while(queue.empty() != True):
            size = queue.qsize()
            for i in range(size):
                curr = queue.get()
                if curr.left != None:
                    queue.put(curr.left)
                if curr.right != None:
                    queue.put(curr.right)
                if i == size-1:
                    result.append(curr.val)
        return result
            
        
        