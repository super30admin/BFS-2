# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = TreeNode()
        self.y_parent = TreeNode()
        if (root == None or x == y):
            return False
        
        self.checker(root,0,None,x,y)
        
        return (self.x_depth == self.y_depth and self.x_parent != self.y_parent)
    
    def checker(self,root,lvl,parent,x,y):
        if(root == None):
            return
        if(root.val == x):
            self.x_depth = lvl
            self.x_parent = parent
        if(root.val == y):
            self.y_depth= lvl
            self.y_parent = parent
            
            
        self.checker(root.left,lvl+1,root,x,y)
        self.checker(root.right,lvl+1,root,x,y)
        