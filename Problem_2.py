# Cousins in a binary tree
 
# Time Complexity : O(N)
# Space Complexity : O(h), h is the height of the tree
# Did this code successfully run on Leetcode : Yes with Runtime: 32 ms and Memory Usage: 14.3 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
The two conditions for returning true for cousins is bodes at same level 
but different Parents. Using DFS recursive approach a Stack is maintained
which stores level. Variables are initialized to meet the condition given.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.x_level, self.x_parent = 0, None # initializing variables to fulfill condition
        self.y_level, self.y_parent = 0, None
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.dfs(root,None,x,y) # helper function
        return (self.x_level==self.y_level) and (self.x_parent is not self.y_parent) # Condition for cousin
    def dfs(self,root,parent,x,y,level=0):
            if root is None: # Edge Case
                return
            if(root.val==x):
                self.x_level=level 
                self.x_parent=parent
            if(root.val==y):
                self.y_level=level
                self.y_parent=parent
            if(root.left):
                self.dfs(root.left,root,x,y,level+1)
            if(root.right):
                self.dfs(root.right,root,x,y,level+1) 
        
 
