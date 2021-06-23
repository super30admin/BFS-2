# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    x_depth, y_depth, x_parent, y_parent = 0,0,None,None
    x_flag, y_flag=False, False
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        :TC:O(n)
        :SC:O(n)
        """
        
        self.dfs(root, None, 0, x, y)
        return (self.x_parent!=self.y_parent) and (self.x_depth==self.y_depth)
    
    def dfs(self, root, parent, depth, x, y):
        # base
        if not root: return
        
        # logic
        if root.val==x:
            self.x_depth=depth
            self.x_parent=parent
            self.x_flag=True
        
        if root.val==y:
            self.y_depth=depth
            self.y_parent=parent
            self.y_flag=True
        if self.x_flag and self.y_flag: return 
        self.dfs(root.left, root, depth+1, x, y)
        self.dfs(root.right, root, depth+1, x, y)
        
        