#Time complexity: O(n)
#Space complexity: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    xParent=None
    yParent=None
    xLevel=0
    yLevel=0
    def isCousins(self, root, x: int, y: int) -> bool:
        self.xParent=None
        self.yParent=None
        self.xLevel=0
        self.yLevel=0
        self.findParentAndLevel(root,x,y,0,None)
        return (self.xLevel==self.yLevel and self.xParent!=self.yParent)
    def findParentAndLevel(self,root,x,y,level,parent):
        if not root:
            return
        if root.val==x:
            self.xParent=parent
            self.xLevel=level
            return
        if root.val==y:
            self.yParent=parent
            self.yLevel=level
            return
        self.findParentAndLevel(root.left,x,y,level+1,root)
        self.findParentAndLevel(root.right,x,y,level+1,root)
        
            
            
        