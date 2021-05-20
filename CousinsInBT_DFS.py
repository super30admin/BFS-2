# TC: O(N) where N is the total number of nodes of the tree
# SC: O(H) where H is the size of the recursive stack or the height of the binary tree.

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x_depth = 0
        self.y_depth = 0
        
        self.x_parent = None
        self.y_parent = None
        
        def dfs(root, x, y, depth, parent):
            if not root:
                return
            
            if root.val == x:
                self.x_depth = depth
                self.x_parent = parent
            if root.val == y:
                self.y_depth = depth
                self.y_parent = parent
            
            dfs(root.left, x, y, depth + 1, root)
            dfs(root.right, x, y, depth + 1, root)
            
        dfs(root, x, y, 0, None)
        if self.x_depth == self.y_depth and self.x_parent != self.y_parent:
            return True
        return False
    
