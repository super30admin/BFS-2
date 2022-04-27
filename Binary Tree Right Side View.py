# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result=[]
        if root==None:return self.result
        self.df(root,0)
        return self.result
    def df(self,root,lvl):
        if root==None:return
        if(len(self.result)==lvl):
            self.result.append(root.val)
        self.df(root.right,lvl+1)
        self.df(root.left,lvl+1)
        
        