# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        def dfs(root,x,y,depth,parent):
            #base
            if root==None:
                return
            
            #If we find the x then we make the aprent as its parent and depth as its depth
            if root.val==x:
                self.x_parent=parent
                self.x_height=depth
            
            #SAME FOR Y
            if root.val==y:
                self.y_parent=parent
                self.y_height=depth
            
            #CALL DFS ON THE LEFT AND RIGHT CHILDREN
            dfs(root.left,x,y,depth+1,root)
            dfs(root.right,x,y,depth+1,root)
                
            
        dfs(root,x,y,0,None)
        #If the parent are not same and the height is same then return tru
        return self.x_parent!=self.y_parent and self.x_height==self.y_height
            
        
        
            