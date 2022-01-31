# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        q = collections.deque()
        
        stack = []
        
        q.append(root)
        
        
        if root == None:
            return None
        
        
        while(len(q) > 0):
            
            size = len(q)
            
            for i in range(0,size):
                
                node = q.popleft()
                if i == size -1:
                    stack.append(node.val)
                if node.left != None:
                    q.append(node.left)
                if node.right != None:
                    q.append(node.right)
        return stack
                    