# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#DFS Method
#T(N) = O(N)
#S(N) = O(H)
class Solution:
    xpar=None
    ypar=None
    xlev=0
    ylev=0
    def helper(self,root,x,y,par,lev):
        #Base
        if root==None:
            return      
        #Logic
        if root.val==x:          #Compare Root with X value
            self.xpar=par
            self.xlev=lev
        elif root.val==y:       #Compare Root with Y value
            print(root.val,par,lev)
            self.ypar=par
            self.ylev=lev
        self.helper(root.left,x,y,root.val,lev+1)
        self.helper(root.right,x,y,root.val,lev+1)
        
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.xpar=None
        self.ypar=None
        self.xlev=0
        self.ylev=0
        
        self.helper(root,x,y,None,0)
        
        if self.xpar!=self.ypar and self.xlev==self.ylev:
            return True
        return False
        
        