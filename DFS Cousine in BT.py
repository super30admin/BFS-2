# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No 

#LOGIC
# go down in tree update the levels as you go
# keep track of parent in each node
# Create variables to store parent_x, parent_y, x_depth, y_depth
# check if these variables match with the given conditions 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    
    
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if not root:return 
        x_parent = None
        y_parent = None
        x_depth = 0
        y_depth = 0
        
        def dfs(cur, parent, level ):
            nonlocal x_parent 
            nonlocal y_parent
            nonlocal x_depth 
            nonlocal y_depth 
            if not cur: return
            
            if cur.val == x:
                x_parent = parent
                x_depth = level
                
            if cur.val == y:
                y_parent = parent
                y_depth = level
            
            dfs(cur.left, cur, level+1)
            dfs(cur.right, cur,level+1)
        
        dfs(root, None, 0)
        
        if x_parent != y_parent and x_depth == y_depth:
            return True
        return False