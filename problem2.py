#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#Traverse through the tree. Search for node x and y. If they are found, then record the depth and parent to a class variable and return. In the calling function, return ttrue if they have the same depth and different parent, fasle otehrwise.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self,root,parent,x,y,depth):
        if(root==None):
            return
        if(self.foundx and self.foundy):
            return
        if(root.val==x):
            self.foundx=True
            self.parentx=parent
            self.depthx=depth
        if(root.val==y):
            self.foundy=True
            self.parenty=parent
            self.depthy=depth
        self.dfs(root.left,root,x,y,depth+1)
        self.dfs(root.right,root,x,y,depth+1)
        
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.foundx=False
        self.foundy=False
        self.parentx=-1
        self.parenty=-1
        self.depthx=-1
        self.depthy=-1
        self.dfs(root,None,x,y,0)
        return self.foundx and self.foundy and self.parentx!=self.parenty and self.depthx==self.depthy
