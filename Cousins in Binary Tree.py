# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if(root == None or x == None or y == None):
            return False
        
        parentX = None
        parentY = None
        depthX = None
        depthY = None
        
        self.recurr(root, x, y, 0, None)
        
        if(self.depthX == self.depthY and self.parentX is not self.parentY):
            print("foo")
            return True
        else:
            return False
        
    def recurr(self, root, x, y, depth, parent):
        if(root == None):
            return
        
        if(root.val == x):
            self.depthX = depth
            self.parentX = parent
        elif(root.val == y):
            self.depthY = depth
            self.parentY = parent
            
        self.recurr(root.left, x, y, depth + 1, root)
        self.recurr(root.right, x, y, depth + 1, root)
