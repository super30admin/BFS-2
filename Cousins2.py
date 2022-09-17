#TC: O(n)
#SC: O(n)
#Program ran on Leetcode successfully

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    
    def __init__(self):
        self.x_parent = None
        self.y_parent = None
        self.x_depth = -1
        self.y_depth = -1
        
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.dfs(root, x, y, 0, None)
        
        if self.x_depth == self.y_depth and self.x_parent != self.y_parent:
            return True
        return False
        
    def dfs(self, root, x, y, depth, parent):
        if root is None:
            return
        
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth
        
        self.dfs(root.left, x, y, depth+1, root)
        self.dfs(root.right, x, y, depth+1, root)