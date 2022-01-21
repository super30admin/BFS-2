'''
TC: O(n)
SC: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        res = list()
        queue = deque()
        queue.append(root) 
        queue.append(None)
        
        while queue:
            top = queue.popleft()
            if not top:
                if not queue:
                    break
                queue.append(None)
                continue
                
            if queue[0] == None:
                res.append(top.val)
            if top.left:
                queue.append(top.left)
            if top.right:
                queue.append(top.right)
        
        return res
        