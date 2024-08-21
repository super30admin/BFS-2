#TC:O(N)
#SC:O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        def dept(node,d,par):
            if not node: return
            if node.val==x:
                self.a=d
                self.aparent=par
            elif node.val==y:
                self.b=d
                self.bparent=par

            dept(node.left,d+1,node)
            dept(node.right,d+1,node)

        dept(root,0,None)

        return self.a==self.b and self.aparent!=self.bparent
            
        