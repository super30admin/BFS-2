# Time Complexity : O(N)  //Where n is the tree we are iterating
#  Space Complexity : O(H)  //We are using the recursive stack
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x = x
        self.y = y
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = 0
        self.y_parent = 0

        #Base case
        if not root:
            return                 
        self.dfs(root, 1, root.val)
        
        #If the depth from left and right is equal and the parents are not equal then we have the cousin tree    
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent

    #Recursively call the dfs till to iterate through the tree
    def dfs(self, root, depth, parent):
        if root is None:
            return None
        
        if root.val == self.x:
            self.x_depth = depth
            self.x_parent = parent
            
        if root.val == self.y:
            self.y_depth = depth
            self.y_parent = parent
        
        
        self.dfs(root.left, depth + 1, root.val)
        self.dfs(root.right, depth + 1, root.val)
       
                
        
    
        