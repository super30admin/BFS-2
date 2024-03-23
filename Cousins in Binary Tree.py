#TC: O(n)
#SC: O(h)

class Solution:
  
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = None
        self.y_parent = None
        
        
        # Helper function for DFS traversal
        def dfs(node, level, parent, x, y):
            if node is None:
                return
            
            if node.val == x:
                self.x_depth = level
                self.x_parent = parent
            if node.val == y:
                self.y_depth = level
                self.y_parent = parent
            
            dfs(node.left, level + 1, node, x, y)
            dfs(node.right, level + 1, node, x, y)

        # Perform DFS traversal
        dfs(root, 0, None, x, y)

        # Check if x and y are at the same depth and have different parents
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent