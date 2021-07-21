# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root==None or root.val==x or root.val==y:
            return False
        #Recursive
        def helper(root,x,y,level,parent):
            if root==None:
                return
            if (self.xlevel!=-1 and self.ylevel!=-1):
                return 
            if x==root.val:
                self.xlevel=level
                self.xparent=parent.val
            if y==root.val:
                self.ylevel=level
                self.yparent=parent.val   
            helper(root.left,x,y,level+1,root)
            helper(root.right,x,y,level+1,root)
        
        self.xlevel=-1
        self.ylevel=-1
        self.xparent=None
        self.yparent=None
        helper(root,x,y,0,None)
        if (self.xlevel!=-1 and self.ylevel!=-1 and self.xlevel==self.ylevel) and (self.xparent!=None and self.yparent!=None and self.xparent!=self.yparent):
            return True
        return False
        #Time O(n)
        #Space O(n)
        
#Iterative approach
#         queue=deque()
#         if root==None or root.val==x or root.val==y:
#             return False
        
#         queue.append(root)
#         xfound=False
#         yfound=False
        
#         while(len(queue)>0):
#             s=len(queue)
            
#             while(s>0):
#                 s-=1
#                 v=queue.popleft()
#                 if v.val==x:
#                         xfound=True      
#                 if v.val==y:
#                         yfound=True
#                 #Sibling check
#                 if ((v.left and v.left.val==x) and(v.right and v.right.val==y)):
#                     return False
#                 if ((v.left and v.left.val==y) and(v.right and v.right.val==x)):
#                     return False
#                 if v.left:
#                     queue.append(v.left)
                 
#                 if v.right:
#                     queue.append(v.right)
#             #Check
#             if (xfound and yfound):
#                 return True
#             if (xfound or yfound):
#                 return False
          
#         return False
        #Time O(n)
        #Space O(n)
        
