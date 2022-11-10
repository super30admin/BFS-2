#Time Complexity - O(n)
#Space Complexity - O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        xfound, yfound = self.helper(root, x, y, None, 0, [], [])
        if xfound == [] and yfound == []:
            return False
        elif xfound == [] or yfound == []:
            return False
        elif xfound[0] != yfound[0] and xfound[1] == yfound[1]:
            return True
        else:
            return False
        
    
    def helper(self, root, x, y, parent, level, xfound, yfound):
        
        if root is None:
            return xfound, yfound
        if root.val == x:
            xfound = [parent, level] 
        if root.val == y:
            yfound = [parent, level] 
    
        xfound, yfound = self.helper(root.left, x, y, root.val, level + 1, xfound, yfound)
        xfound, yfound = self.helper(root.right, x, y, root.val, level + 1, xfound, yfound)
        
        return xfound, yfound