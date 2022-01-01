# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    xLevel,yLevel,xParent,yParent= None,None,None,None
    
    def dfs(self,root,level,parent,x,y):
        if root==None:
            return 
        
        if(root.val==x):
            self.xLevel = level
            self.xParent = parent
        if(root.val==y):
            self.yLevel= level
            self.yParent = parent
        
        self.dfs(root.left,level+1,root,x,y)
        self.dfs(root.right,level+1,root,x,y)
    
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root==None:
            return False
        xLevel,yLevel,xFound,yFound = 0,0,False,False
        
        self.dfs(root,0,None,x,y)
        
        return ((self.xParent!=self.yParent) and (self.xLevel==self.yLevel))
        
        
        