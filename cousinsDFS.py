# Time Complexity: O(n)
# Space Complexity: O(h)



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        
        self.dfs(root, None, 0, x, y)
        
        return (self.x_depth == self.y_depth) and (self.x_parent != self.y_parent)



    def dfs(self, root: Optional[TreeNode], parent: Optional[TreeNode], level: int, x: int, y: int) -> None:

        if root is None:
            return
        
        if root.val == x:
            self.x_depth = level
            self.x_parent = parent
        
        if root.val == y:
            self.y_depth = level
            self.y_parent = parent
        
        self.dfs(root.left, root, level + 1, x, y)
        self.dfs(root.right, root, level + 1, x, y)
