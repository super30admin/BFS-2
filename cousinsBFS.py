#Time Complexity: O(n)
#Space Complexity: O(n)
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            xFlag = False
            yFlag = False
            
            for i in range(size):
                curr = q.popleft()
                if curr.val == x:
                    xFlag = True
                if curr.val == y:
                    yFlag = True
                
                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left is not None:
                    q.append(curr.left)
                
                if curr.right is not None:
                    q.append(curr.right)
                
            if xFlag and yFlag:
                return True
            if xFlag or yFlag:
                return False
        return False
                    
            
        
        
        
        
