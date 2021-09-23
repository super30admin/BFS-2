#Time Complexity : O(n)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    x_depth = y_depth = -1
    x_par = y_par = None
    def dfs(self, root, x, y, lvl, par):
        if root==None:
            return
        
        if root.val == x:
            Solution.x_par = par
            Solution.x_depth = lvl
        if root.val == y:
            Solution.y_par = par
            Solution.y_depth = lvl
        if Solution.x_depth != -1 and Solution.y_depth != -1:
            return
        self.dfs(root.left, x, y, lvl+1, root)
        self.dfs(root.right, x, y, lvl+1, root)
        
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        Solution.x_depth = Solution.y_depth = -1
        Solution.x_par = Solution.y_par = None
        if root == None:
            return False
        self.dfs(root, x, y, 0, None)
        return Solution.x_depth == Solution.y_depth and Solution.x_par != Solution.y_par
    