# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    """BFS Implementation
    Time Complexity-O(n)
    Space Complexity-O(n)"""
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        q= deque()
        q.append(root)
        while q:
            x_found=False
            y_found=False
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                if curr.val==x:
                    x_found=True
                if curr.val==y:
                    y_found=True
                if curr.left and curr.right:
                    if curr.left.val==x and curr.right.val==y:
                        return False
                    if curr.left.val==y and curr.right.val==x:
                        return False
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        return False
        
                    
                
                    
        
    """Time complexity-O(n)
    Space complexity-O(h)"""
#     def __init__(self):
#         self.x_level=None
#         self.y_level=None
#         self.x_parent=None
#         self.y_parent=None
#         self.x_flag=False
#         self.y_flag=False
        
#     def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
#         if root.val==x or root.val==y:
#             return False
#         if not root:
#             return
#         return self.dfs(root, 0, None, x, y)
        
#     def dfs(self, root, level, parent, x, y):
#         if not root:
#             return 
#         if root.val==x:
#             self.x_parent=parent
#             self.x_level=level
#             self.x_flag=True
#         if root.val==y:
#             self.y_parent=parent
#             self.y_level=level
#             self.y_flag=True
#         if not self.x_flag or not self.y_flag:
#             self.dfs(root.left, level+1, root, x, y)
#         if not self.x_flag or not self.y_flag:
#             self.dfs(root.right, level+1, root, x, y)
#         if self.x_parent!=self.y_parent and self.x_level==self.y_level:
#             return True
        