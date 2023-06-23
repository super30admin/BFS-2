# Using DFS
# Time and space complexity : O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = None
        self.y_parent = None
        self.dfs(root,x,y,0,None)
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent
    def dfs(self, root: Optional[TreeNode], x: int, y: int, depth: int, parent: TreeNode):
        #base
        if root is None:
            return
        #logic
        if(root.val == x):
            self.x_depth = depth
            self.x_parent = parent
        if(root.val == y):
            self.y_depth = depth
            self.y_parent = parent
        self.dfs(root.left,x,y,depth+1,root)
        self.dfs(root.right,x,y,depth+1,root)
