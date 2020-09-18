# Time complexity - O(N) - going through every element in the tree
# Space complexity - O(H) recursion stack 
# using recursion and checking if depth of x and y are equal along with parents not being equal



# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        
        self.depthX = 0
        self.depthY = 0
        self.parentX = None
        self.parentY = None
        
        
        
        
        def dfs(root, depth, parent = None):
            
            if root is None:
                return

            if root:
                if root.val == x:
                    self.depthX = depth
                    self.parentX = parent
                if root.val == y:
                    self.depthY = depth
                    self.parentY = parent
                    
                dfs(root.left, depth + 1, parent = root.val)
                dfs(root.right, depth + 1, parent = root.val)
         
            
        dfs(root, depth = 0, parent = None)
        return self.depthX == self.depthY and self.parentX != self.parentY
