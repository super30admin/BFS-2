# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root: return False
        self.xlvl=self.ylvl=-1
        self.xparent=self.yparent=None
        def helper(root, lvl, parent):
            if not root: return
            if self.xparent and self.yparent: return
            if root.val==x: self.xparent=parent; self.xlvl= lvl
            if root.val==y: self.yparent=parent; self.ylvl= lvl
            helper(root=root.left, lvl=lvl+1, parent=root)
            helper(root=root.right, lvl=lvl+1, parent=root)
        helper(root=root, lvl=0, parent=None)
        print(self.xlvl,self.ylvl,self.xparent,self.yparent)
        return True if self.xlvl==self.ylvl and self.xparent!=self.yparent else False