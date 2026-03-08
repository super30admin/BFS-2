# problem 2 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def helper(self,root,x,y,depth,parent):
        if not root:
            return 
        if x == root.val:
            self.x_depth = depth 
            self.x_parent = parent

        if y == root.val:
            self.y_depth = depth
            self.y_parent = parent

        self.helper(root.left,x,y,depth+1,root)
        self.helper(root.right,x,y,depth+1,root)

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent = None
        self.y_parent = None 
        self.x_depth = -1 
        self.y_depth = -1 

        self.helper(root,x,y,0,None)

        if self.x_parent != self.y_parent and self.x_depth == self.y_depth:
            return True 
        return False
