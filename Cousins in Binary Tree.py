# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    x_lvl,y_lvl=0,0
    x_parent,y_parent=None,None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root ==None:return False
        self.dfs(root,0,None,x,y)
        return self.x_lvl==self.y_lvl and self.x_parent!=self.y_parent
    def dfs(self,root,lvl,parent,x,y):
        if root==None:return
        if(root.val==x):
            self.x_lvl=lvl
            self.x_parent=parent
        if(root.val==y):
            self.y_lvl=lvl
            self.y_parent=parent
        self.dfs(root.left,lvl+1,root,x,y)
        self.dfs(root.right,lvl+1,root,x,y)       