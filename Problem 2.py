# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time: O(n)
# Space: O(n) # If we include recursive stack space
class Solution(object):
    def __init__(self):
        self.levelx = 0
        self.levely = sys.maxint
        self.parentx = None
        self.parenty = None
        
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.helper(root, x,y, 0)
        if self.levelx == self.levely and self.parentx != self.parenty:
            return True
        return False
        
    def helper(self, root, x, y, level):
        if root == None:
            return
        if root.right != None and root.right.val == x:
            self.parentx = root
            self.levelx = level+1
        if root.left != None and root.left.val == x:
            self.parentx = root
            self.levelx = level+1
        if root.right != None and root.right.val == y:
            self.parenty = root
            self.levely = level+1
        if root.left != None and root.left.val == y:
            self.parenty = root
            self.levely = level+1
        self.helper(root.right, x,y, level+1)
        self.helper(root.left, x,y, level+1)
        return
            
        
