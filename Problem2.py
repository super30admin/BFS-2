# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    x_level = None
    y_level = None
    x_parent = None
    y_parent = None
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.x_level = -1
        self.y_level = -1
        self.x_parent = None
        self.y_parent = None
        self.dfs(root,x,y,0,None)
        return self.x_level == self.y_level and self.x_parent != self.y_parent
    def dfs(self,root,x,y,level,parent):

        if root == None: return

        if root.val == x:
            self.x_level = level
            self.x_parent = parent
        if root.val == y:
            self.y_level = level
            self.y_parent = parent
        self.dfs(root.left,x,y,level+1,root)
        self.dfs(root.right,x,y,level+1,root)
    