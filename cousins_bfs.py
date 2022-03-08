#time-n, space-h
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q=deque()
        q.append(root)
        cnt=0
        while q:
            size=len(q)
            print(size)
            cnt=0
            for i in range(size):
                curr=q.popleft()
                if curr.left and curr.right:
                    if (curr.left.val==x and curr.right.val==y) or (curr.left.val==y and curr.right.val==x):
                        print("x")
                        return False
                
               
                if curr.left:
                    if curr.left.val==x or curr.left.val==y:
                        cnt+=1
                    q.append(curr.left)
                if curr.right:
                    if curr.right.val==x or curr.right.val==y:
                        cnt+=1
                    q.append(curr.right)
            print(cnt)
            if cnt==2:
                return True
        return False
                    
                
        