# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
TC/SC: 
"""
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        xdata=[]
        ydata=[]
        queue = deque([[root,0,0]])
        while queue:
            xfound = False
            yfound = False
            for _ in range(len(queue)):
                node,parent,dist = queue.popleft()
                if node.val == x:
                    xfound = True
                    xdata = [node,parent,dist]
                if node.val == y:
                    yfound = True
                    ydata =[node,parent,dist]
                if node.left:
                    queue.append([node.left,node.val,dist+1])
                if node.right:
                    queue.append([node.right,node.val,dist+1])    
            if xfound ^ yfound :
                    return False
            if xfound and yfound :
                    return True if xdata[1] != ydata[1] else False
        
        return False
