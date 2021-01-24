# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    
    """
    Description: Find cousins in Binary Tree
    
    Time Complexicity: O(n), n -> number of elements in the tree
    Space Complexicity: O(h), h -> height/depth of the tree
    
    Approach:
    1. Use DFS to check if parents of x and y and depth 
    2. in recursive stack update the parent, and depth for each subtree
    3. match the criteria for same depth and different parents
    """
    
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if root == None: return
        self.x_parent = TreeNode(); self.y_parent = TreeNode()
        self.x_depth = 0; self.y_depth = 0
        self.dfs(root, None, 0, x, y)
        return self.x_parent != self.y_parent and self.x_depth == self.y_depth
    
    def dfs(self, root, parent, depth, x, y):
        
        # Base case
        if root == None: return
        
        # logic
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
            
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth
            
        self.dfs(root.left, root, depth + 1, x, y)
        self.dfs(root.right, root, depth + 1, x, y)
