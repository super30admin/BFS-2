'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(h) -- height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.x_parent = None
        self.x_level = None
        
        self.y_parent = None
        self.y_level = None
    
    def dfsWay(self,root,level,x,y):
        
        # base
        
        if (root == None) or (self.x_parent != None and self.y_parent != None) :
            return
        
        
        # logic
        
        if self.x_parent == None:
            # do something
            
            # chk for lhs
            if root.left != None and root.left.val == x:
                self.x_parent = root
                self.x_level = level + 1
            
            # chk for rhs
            if root.right != None and root.right.val == x:
                self.x_parent = root
                self.x_level = level + 1
        
        if self.y_parent == None:
            # do something
            
            # chk for rhs
            if root.left != None and root.left.val == y:
                self.y_parent = root
                self.y_level = level + 1
            
            # chk for rhs
            if root.right != None and root.right.val == y:
                self.y_parent = root
                self.y_level = level + 1
            
        # recursive call on lhs
        self.dfsWay(root.left,level+1,x,y)
        
        # recursive call on lhs
        self.dfsWay(root.right,level+1,x,y)
    
        
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        self.dfsWay(root,0,x,y)
        
        if (self.x_level == self.y_level) and (self.x_parent != self.y_parent):
            return True
        
        else:
            return False
        