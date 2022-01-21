'''

TC: O(N)
OC: O(H)

'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return True
        
        def findHaP(node, target, parent = None, height = 0):
            
            if node.val == target:
                return height, parent
            
            fh, fp = None, None
            
            if node.left:
                fh, fp = findHaP(node.left, target, node.val, height + 1)
            
            if fh != None:
                return fh, fp
            
            if node.right:
                fh, fp = findHaP(node.right, target, node.val, height + 1)
            
            return fh, fp
        
        lh, lp = findHaP(root, x)
        rh, rp = findHaP(root, y)
        
        return (lh == rh and lp != rp)
            
            
        