# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_depth=math.inf
        self.y_depth=math.inf
        
        self.x_parent=self.y_parent=None
        
        def cousin(root,depth,parent):
            if root is None or depth>self.x_depth or depth>self.y_depth:
                return False
            
            if root.val==x:
                self.x_depth=depth
                self.x_parent=parent
                return (self.x_depth==self.y_depth and self.x_parent!=self.y_parent)
            
            if root.val==y:
                self.y_depth=depth
                self.y_parent=parent
                return (self.x_depth==self.y_depth and self.x_parent!=self.y_parent)
            
            return cousin(root.left,depth+1,root) or cousin(root.right,depth+1,root)
        
        return cousin(root,0,None)
				
				
        
        
        
            
        