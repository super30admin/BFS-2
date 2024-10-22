# T.C = O(n) S.C = O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    global x_level,y_level,x_parent,y_parent
    x_level = y_level = -1
    x_parent = y_parent = None
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        global x_level,y_level,x_parent,y_parent
        x_level = y_level = -1
        x_parent = y_parent = None
        self.helper(root,x,y,0,None)
        return x_level == y_level and x_parent != y_parent

    def helper(self,root,x,y,level,parent):
        global x_level, y_level, x_parent, y_parent
        if root is None:
            return

        if(root.val == x):
            x_level = level
            x_parent = parent

        if(root.val == y):
            y_level = level
            y_parent = parent

        self.helper(root.left,x,y,level+1,root)
        self.helper(root.right,x,y,level+1,root)
        