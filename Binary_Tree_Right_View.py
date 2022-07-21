# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        l=[]
        depth=0
        
        def right_side(root,level):
            nonlocal depth
            if root is None:
                return
            
            if depth<level:
                l.append(root.val)
                depth=level
            
            right_side(root.right,level+1) 
            right_side(root.left,level+1)
                
        right_side(root,1)
        
        return l
                
                
                