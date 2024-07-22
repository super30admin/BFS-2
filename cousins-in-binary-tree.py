#Time Complexity O(n)
#Space Complexity O(h)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_parent = None
        y_parent = None
        x_depth = 0
        y_depth = 0
        level = 0
        parent = None
        def helper(root, level, parent, x, y):
            nonlocal x_parent, y_parent, x_depth, y_depth
            if root == None: return

            if root.val == x:
                x_parent = parent
                x_depth = level
            if root.val == y:
                y_parent = parent
                y_depth = level

            helper(root.left, level+1, root, x, y)
            helper(root.right, level+1, root, x, y)

        helper(root, level, parent, x, y)
        print(x_parent, y_parent, x_depth, y_depth)
        return x_parent != y_parent and x_depth == y_depth
        