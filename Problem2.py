#Time complexity is O(n)
#Space complexity is O(n)
#Code ran successfully on leetcode
#Faced no issues while coding

#Cousins in a binary tree
#time complexity is O(n)
#SPace complexity is O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#DFS solution
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        #Initializing the required variables
        self.x_depth=0
        self.y_depth=0
        self.x_parent=None
        self.y_parent=None
        self.dfs(root,x,y,0,None)
        #We will returning the value based on the below condition
        return self.x_depth==self.y_depth and self.x_parent!=self.y_parent

    def dfs(self,root,x,y,depth,parent):
        if(root==None):
            return
        #If the required value is found in tree, we will update depth and corresponding parent value
        if(root.val==x):
            self.x_depth=depth
            self.x_parent=parent
        if(root.val==y):
            self.y_depth=depth
            self.y_parent=parent
        #Iteratively calling the left and right side of the tree
        self.dfs(root.left,x,y,depth+1,root)
        self.dfs(root.right,x,y,depth+1,root)