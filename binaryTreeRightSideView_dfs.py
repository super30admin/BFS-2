# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # dfs approach
    # TC : O(n)
    # SC : O(1)
    def dfs(self,root: Optional[TreeNode],parent: Optional[TreeNode],level: int,x: int,y: int) -> None:
        # base
        if root is None or (self.xlevel != -1 and self.ylevel!=-1):
            return
        # logic    
        if root.val == x:
            self.xparent=parent
            self.xlevel = level
        if root.val == y:
            self.yparent = parent
            self.ylevel = level
        self.dfs(root.left,root,level+1,x,y)
        self.dfs(root.right,root,level+1,x,y)
        

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return
        self.xparent,self.yparent = None,None
        self.xlevel,self.ylevel = -1,-1
        self.dfs(root,None,0,x,y)
        return self.xparent != self.yparent and self.xlevel == self.ylevel
    