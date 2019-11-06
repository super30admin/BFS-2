# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q1 = deque()
        q1.append(root)
        q2 = deque()
        current_level = 0
        while q1:
            filtered = list(filter(lambda l : (l.val == x) or (l.val == y),q1))
            if len(filtered) == 1 :
                return False 

            if len(filtered) == 2 :
                return (current_level > 1) 
            
            
            while q1 :
                e = q1.popleft()
                if e.left and e.right :
                    if (e.left.val == x) and (e.right.val == y) :
                        return False
                    if (e.left.val == y) and (e.right.val == x) :
                        return False
                if e.left :
                    q2.append(e.left)
                if e.right :
                    q2.append(e.right)
            
