# Time complexity: O(n)
# Space complexity: O(n) recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Do a DFS to determine the parent and depth of each node. Then check if the parents are not same and depth is same

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        px = None
        py = None
        depth_x = 0
        depth_y = 0

        def dfs(root, parent, depth):
            nonlocal px, py, depth_x, depth_y
            if not root: return None

            if root.val == x:
                depth_x = depth
                px = parent

            if root.val == y:
                depth_y = depth
                py = parent

            dfs(root.left, root, depth + 1)
            dfs(root.right, root, depth + 1)

        dfs(root, None, 0)

        if (px != py and depth_x == depth_y):
            return True

        return False