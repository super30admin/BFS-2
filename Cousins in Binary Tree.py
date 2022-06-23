# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
#     dfs
# time complexity is o(n), where n is the size of the input
# space complexity is o(h), h = log(n), where n is the size of the input, o(h) is Recursive stack space.
    xparent = TreeNode()
    yparent = TreeNode()
    xlevel = 0
    ylevel = 0
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.dfs(root, 0, None, x, y)
        if(self.xlevel == self.ylevel and self.xparent != self.yparent):
            return True
        else:
            False      
        
    def dfs(self, root, level, parent, x, y):
        if(root == None):
            return
        if(root.val == x):
            self.xparent = parent
            self.xlevel = level
        if(root.val == y):
            self.yparent = parent
            self.ylevel = level
        if(self.xparent != None or self.yparent != None):
            self.dfs(root.left, level + 1, root, x, y)
        if(self.xparent != None or self.yparent != None):
            self.dfs(root.right, level + 1, root, x, y)
        
        
        
#         bfs
# time complexity is o(n), where n is the size of the input
# space complexity is o(n),where n is the size of the input
#         from collections import deque
#         q = deque()
#         q.append(root)
#         flag_x = False
#         flag_y = False
#         while(len(q) != 0):
#             l = len(q)
#             for i in range(l):
#                 curr = q.popleft()
#                 if(curr.left != None and curr.right != None):
#                     if(curr.left.val == x and curr.right.val == y):
#                         return False
#                     if(curr.left.val == y and curr.right.val == x):
#                         return False
#                 if(curr.left != None):
#                     q.append(curr.left)
#                     if(curr.left.val == x):
#                         flag_x = True
#                     if(curr.left.val == y):
#                         flag_y = True
#                 if(curr.right != None):
#                     q.append(curr.right)
#                     if(curr.right.val == x):
#                         flag_x = True
#                     if(curr.right.val == y):
#                         flag_y = True
#             if(flag_x and flag_y):
#                 return True
#             if(flag_x or flag_y):
#                 return False

            
            
        
        
        