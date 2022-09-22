# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        res = []
        
        def dfs(root,x,y,temp,level):
            if(root is None):
                return
            if(root.val==x or root.val==y):
                res.append((temp,level))
            dfs(root.left,x,y,root.val,level+1)
            dfs(root.right,x,y,root.val,level+1)
            
        dfs(root,x,y,None,0)
        
        if(res[0][0]!=res[1][0] and res[0][1]==res[1][1]):
            return True
        
        return False
               
        