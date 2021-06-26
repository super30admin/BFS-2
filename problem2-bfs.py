# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            xflag = False
            yflag = False
            for _ in range(size):
                curr = q.popleft()
                if curr.left != None and curr.right != None:  #checking if children have common parent or not
                    if curr.left.val == x and curr.right.val == y: return False
                    if curr.left.val == y and curr.right.val == x: return False
                if curr.val == x: xflag = True 
                if curr.val == y: yflag = True
                if curr.left != None: q.append(curr.left)
                if curr.right != None: q.append(curr.right)
            if xflag and yflag == True: return True
        return False
                    
                    
                
                
            
#Time complexity O(n)
#Space complexity O(n)
#Using BFS to record child and parent value and comparing if the child values are at same level and parents are different or not.
        