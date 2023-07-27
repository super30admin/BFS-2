# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        
        self.x_parent = TreeNode()
        self.y_parent = TreeNode()
        self.x_depth = 0
        self.y_depth = 0

        def dfs(node, parent, depth):
            # base
            if node is None:
                return

            # main logic
            if node.val == x:
                self.x_parent = parent
                self.x_depth = depth
            
            if node.val == y:
                self.y_parent = parent
                self.y_depth = depth
            
            dfs(node.left, node, depth+1)
            dfs(node.right, node, depth+1)

        
        dfs(root, None, 0)
        return self.x_parent != self.y_parent and self.x_depth == self.y_depth



                 