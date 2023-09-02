# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.x_depth = 0
        self.y_depth = 0
        self.x_p = None
        self.y_p = None

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.dfs(root,x,y,0,None)
        if self.x_depth == self.y_depth and self.x_p.val != self.y_p.val: 
            return True
        else: 
            return False

    def dfs(self,root,x,y,depth,parent):
        if root is None:
            return

        if root.val == x:
            self.x_depth = depth
            self.x_p = parent

        if root.val == y:
            self.y_depth = depth
            self.y_p = parent
        
        self.dfs(root.left,x,y,depth+1,root)
        self.dfs(root.right,x,y,depth+1,root)

    
        