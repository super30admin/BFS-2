#time-n, space-h
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.level_x=0
        self.level_y=0
        self.parent_x=None
        self.parent_y=None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        parent= None
        self.dfs(root,parent,x,y,0)
        # print(self.parent_x.val,self.parent_y.val,self.level_x,self.level_y)
        if self.parent_x==self.parent_y:
            return False
        return self.level_x==self.level_y
    def dfs(self,root,parent,x,y,level):
        #base
        if root is None:
            return
        #logic
        if root.val==x:
            self.level_x=level
            self.parent_x=parent
        if root.val==y:
            self.level_y=level
            self.parent_y=parent
        if root.left:
            self.dfs(root.left,root,x,y,level+1)
        if root.right:
            self.dfs(root.right,root,x,y,level+1)
        
