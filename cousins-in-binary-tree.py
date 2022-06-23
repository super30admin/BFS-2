# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent,self.y_parent=None,None
        self.x_ht,self.y_ht=None,None    
        self.dfs(root,None,0,x,y)
        return self.x_parent!=self.y_parent and self.x_ht==self.y_ht
    def dfs(self,root:Optional[TreeNode], parent:Optional[TreeNode],level:int,x: int, y: int):
        if root==None:return
        # print(x,y)
        if root.val==x:
            self.x_parent=parent
            self.x_ht=level
        if root.val==y:
            self.y_parent=parent
            self.y_ht=level
        # print(self.x_parent,self.y_parent)
        if self.x_parent==None or self.y_parent==None:
            self.dfs(root.left,root,level+1,x,y)
        if self.x_parent==None or self.y_parent==None:
            self.dfs(root.right,root,level+1,x,y)
    
#     # BFS
#     # Time Complexity: O(n)
#     # Space Complexity: O(n)
#     def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
#         if root==None: return False
#         from collections import deque
#         q=deque()
#         q.append(root)
#         while len(q)!=0:
#             x_flag=False
#             y_flag=False
#             for i in range(len(q)):
#                 curr=q.popleft()
#                 # print(curr)
#                 if curr.val==x: x_flag=True
#                 if curr.val==y: y_flag=True
#                 if curr.left!=None and curr.right!=None:
#                     if curr.left.val==x and curr.right.val==y: return False
#                     if curr.left.val==y and curr.right.val==x: return False
#                 if curr.left!=None: q.append(curr.left)
#                 if curr.right!=None: q.append(curr.right)
#             if x_flag==True and y_flag==True: return True
#             if x_flag==True or y_flag==True: return False
#         return False
            
        
        
        