# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity --> O(n) where n is the number of nodes
# Space Complexity --> O(logn)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent, self.y_parent = None, None
        self.x_level, self.y_level = -1, -1

        def helper(root, level, parent):
            # base
            if root is None:
                return 
            
            # logic
            if root.val == x:
                self.x_level = level
                self.x_parent = parent
            if root.val == y:
                self.y_level = level
                self.y_parent = parent

            if self.x_parent is None or self.y_parent is None:
                helper(root.left, level+1, root)
                helper(root.right, level+1, root)

        helper(root, 0, None)
        if self.x_level != self.y_level:
            return False
        return self.x_parent!=self.y_parent 
