# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:

        res = [-1, -1, None, None]

        def dfs(root, level, parent):
            if not root:
                return

            if root.val == x:
                res[0] = level
                res[2] = parent.val if parent else None
            elif root.val == y:
                res[1] = level
                res[3] = parent.val if parent else None
            
            dfs(root.left, level+1, root)
            dfs(root.right, level+1, root)
        
        
        dfs(root, 0, None)

        x_level, y_level, x_parent, y_parent = res

        return not (x_level == -1 or y_level == -1 or x_level != y_level or x_parent == y_parent)
