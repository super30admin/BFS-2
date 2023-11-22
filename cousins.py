# O(N) -- O(N)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        #Calculate the Depth and Parent of x and y
        def dfs(root, depth, parent):
            nonlocal x_depth, x_parent, y_depth, y_parent
            if not root:
                return
            
            if root.val == x :
                x_parent, x_depth = parent, depth
            if root.val == y :
                y_parent, y_depth = parent, depth
            
            dfs(root.left, depth + 1, root)
            dfs(root.right, depth + 1, root)
        
        x_parent, y_parent = None, None
        x_depth, y_depth = 0, 0

        dfs(root, 0, None)

        #Process and Return
        if x_depth == y_depth and x_parent != y_parent:
            return True
        return False