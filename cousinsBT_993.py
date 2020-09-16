# // Time Complexity : O(n)
# // Space Complexity : O(n), with recursive stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    #maintain global variables for both node's parent and depth
    def __init__(self):
        self.depth1 = -1
        self.depth2 = -1
        self.parentX = None
        self.parentY = None
    
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if not root:
            return 
        
        #call recursive function
        self.recur(root, x, y, 0, None)
        
        #if both the conditions are satisfied, return True
        if self.depthX == self.depthY and self.parentX != self.parentY:
            return True
        else:
            return False
        
    
    def recur(self, root:TreeNode, x, y, depth, parent):
        
        if not root:
            return
        
        #when you find the node, update its parent and depth
        if root.val == x:
            self.depthX = depth
            self.parentX = parent
        elif root.val == y:
            self.depthY = depth
            self.parentY = parent
        
        #make recursive calls on left and right child
        self.recur(root.left, x, y, depth+1, root)
        self.recur(root.right, x, y, depth+1, root)
        