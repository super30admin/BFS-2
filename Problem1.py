"""
// Time Complexity : o(n), n-> number of nodes
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

--> find depths and parents of x and y and check if depths are equal and parents are different

// Your code here along with comments explaining your approach
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def depth_n_parent(self, root,x,y,depth,parent): #function to find the depths and parents of x and y 
        if not root:
            return
        
        if root.val == x: #if found, set the values of the global variables
            self.x_par = parent
            self.x_depth = depth
            
        if root.val == y:
            self.y_par = parent
            self.y_depth = depth
            
        self.depth_n_parent(root.left,x,y,depth+1,root) #recurse for left and right children and keep increasing the depth and setting root as parent for the next recursion
        self.depth_n_parent(root.right,x,y,depth+1,root)
        
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.x_depth = 0
        self.y_depth = 0
        self.x_par = None
        self.y_par = None
        
        self.depth_n_parent(root, x,y,0,None) #parent of root set to None
        
        if self.x_depth == self.y_depth and self.x_par != self.y_par: # if the depths are equal and parents are different then x and y are cousins
            return True
        return False