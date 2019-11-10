"""DFS approach"""
#Accepted on Leetcode
#Time complexity - O(N)
#Space complexity - O(H)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    X_parent = None #Encapsulation
    Y_parent = None #Encapsulation
    X_depth = -1 #Encapsulation
    Y_depth = -1 #Encapsulation
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.X_parent = None
        self.Y_parent = None
        self. X_depth = -1
        self. Y_depth = -1
        #Root doesn't have parents
        self.helper(root,x,y,0,None)
        return (self.X_depth == self.Y_depth) and (self.X_parent != self.Y_parent)
        
    def helper(self,root,x,y,depth,parent):
        #Edge case
        if not root: return 
        #Base case
        if root.val == x:
            self.X_depth=depth
            self.X_parent=parent
        if root.val == y:
            self.Y_depth=depth
            self.Y_parent=parent
        self.helper(root.left,x,y,depth+1,root)
        self.helper(root.right,x,y,depth+1,root)