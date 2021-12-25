class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(h)
    def isCousins(self, root, x: int, y: int) -> bool:
        self.x_parent, self.y_parent = TreeNode(), TreeNode()
        self.x_level, self.y_level = 0, 0

        if root is None:
            return False
        self.dfs(root, x, y, 0, None)

        return self.x_parent != self.y_parent and self.x_level == self.y_level

    def dfs(self, root, x, y, lvl, parent):
        # Base Condition
        if root is None:
            return

        # Logic
        if root.val == x:
            self.x_parent = parent
            self.x_level = lvl

        if root.val == y:
            self.y_parent = parent
            self.y_level = lvl

        self.dfs(root.left, x, y, lvl + 1, root)
        self.dfs(root.right, x, y, lvl + 1, root)