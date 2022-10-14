#Time complexity - O(n) for BFS and DFS
#Space Complexity - BFS - O(n), DFS - O(h)

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


#DFS
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if (root is None) or (x == y):
            return False
        
        self.dfs(root, None, x, y, 0)
        
        return (self.x_parent != self.y_parent) and (self.x_lvl == self.y_lvl)
        
        
    def dfs(self, root: Optional[TreeNode], parent: Optional[TreeNode], x: int, y: int, lvl: int):
        if root is None:
            return
        
        if root.val == x:   
            self.x_parent = parent
            self.x_lvl = lvl
        if root.val == y:   
            self.y_parent = parent
            self.y_lvl = lvl
        
        self.dfs(root.left, root, x, y, lvl + 1)
        self.dfs(root.right, root, x, y, lvl + 1)
            

# #BFS
# class Solution:
#     def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
#         if (root is None) or (x == y):
#             return False
        
#         q = collections.deque()
#         q.append(root)
        
#         while(q):
#             size = len(q)
#             x_found = False
#             y_found = False
            
#             for i in range(size):
#                 curr = q.popleft()
                
#                 #if x and y are siblings
#                 if curr.left and curr.right:
#                     if (curr.left.val == x and curr.right.val == y ):
#                         return False
#                     if (curr.left.val == y and curr.right.val == x ):
#                         return False
            
#                 if curr.val == x:
#                     x_found = True
#                 if curr.val == y:
#                     y_found = True
                    
#                 if curr.left:
#                     q.append(curr.left)
#                 if curr.right:
#                     q.append(curr.right)
                
#             #if x and y are found in the same level return True
#             if x_found and y_found:
#                 return True
            
#         return False