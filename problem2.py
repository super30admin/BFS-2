#Time Complexity : O(n)
#Space Complexity : O(n) --- when we have a skewed tree
#Any problem you faced while coding this : -

#The approach is a standard depth traversal. We traverse by tracking the depth from the root and keep on checking the values of the children. Once the children are found, we store the depth and immediate parent. Return the answer based on the parent's value and equal depth.

class Solution:
    x_depth, y_depth = 0, 0
    x_parent, y_parent = None, None

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.dfs(root, x, y, 0, None)

        return self.x_depth == self.y_depth and self.x_parent != self.y_parent

    def dfs(self, root, x, y, depth, parent):
        if not root:
            return 

        if root.val == x:
            self.x_depth = depth
            self.x_parent = parent

        if root.val == y:
            self.y_depth = depth
            self.y_parent = parent

        self.dfs(root.left, x, y, depth + 1, root)
        self.dfs(root.right, x, y, depth + 1, root)