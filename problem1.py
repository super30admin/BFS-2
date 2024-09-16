# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __init__(self):
        self.x_parent = None
        self.x_level = -1
        self.y_parent = None
        self.y_level = None
        
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.tranverseTree(root,x,y,0)
        if self.x_parent is None or self.y_parent is None:
            return False
        if self.x_level == self.y_level and self.x_parent != self.y_parent:
            return True
        return False
        
    def tranverseTree(self, root, x, y, level):
        
            
        if root.left != None:
            if x == root.left.val:
                self.x_parent = root.val
                self.x_level = level + 1
            if y == root.left.val:
                self.y_parent = root.val
                self.y_level = level + 1
        
        if root.right != None:
            if x == root.right.val:
                self.x_parent = root.val
                self.x_level = level + 1
            if y == root.right.val:
                self.y_parent = root.val
                self.y_level = level + 1
                
        if self.x_parent is not None and self.y_parent is not None:
            return
        
        if root.left != None:
            self.tranverseTree(root.left, x, y, level+1)
        if root.right != None:
            self.tranverseTree(root.right, x, y, level+1)
            
# Time complexity: O(n)
# Space complexity: O(n)
            