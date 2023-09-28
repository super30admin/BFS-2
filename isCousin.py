# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root, x: int, y: int) -> bool:
        if not root:
            return root

        self.xlevel = 0
        self.ylevel = 0
        self.xparent = None
        self.yparent = None
        def dfs(root, level, parent):
            if not root:
                return
            if root.val == x:
                self.xlevel = level
                self.xparent = parent
            if root.val == y:
                self.ylevel = level
                self.yparent = parent
            
            dfs(root.left, level+1, root)
            dfs(root.right, level+1, root)

        dfs(root, 0, None)
        return (self.xlevel == self.ylevel) and (self.xparent != self.yparent)
    
#TC: O(n)
#Sc: O(h)

