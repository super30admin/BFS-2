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
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
      
       # empty list for the result
        res = []
        
       # if tree is empty, then return empty list
        if not root:
            return res
        # add the root to the queue
        q = deque([root,])
        
        # traverse until the queue is not empty
        while q:
            # maintain the size of the queue
            size = len(q)
            
            # for each element in the queue, we pop that element from queue and check if the element of that depth is already presne, if presne, then 
            # add that value to the res
            for i in range(size):
                curr = q.popleft()
                if i == size-1:
                    res.append(curr.val)
                # add the left and right child of the root node
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return res
        
