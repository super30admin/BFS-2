# // Time Complexity : O(N)
# // Space Complexity :O(H)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :



# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
#dfs on left side first
class Solution:
    result = list()
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.dfsLeft(root, 0)
        return self.result
    #dfs on left side first
    def dfsLeft(self,root,level):
        # base 
        if root == None:
            return
        # logic
        if(level == len(self.result)):
            self.result.append(root.val)
        else:
            self.result[level]= root.val
            
        self.dfsLeft(root.left, level+1)
        self.dfsLeft(root.right, level+1)

    #dfs on right side first
class Solution:
    result = list()
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.dfsRight(root, 0)
        return self.result
    def dfsRight(self,root,level):
        # base 
        if root == None:
            return
        # logic
        if(level == len(self.result)):
            self.result.append(root.val)
            
        self.dfsRight(root.right, level+1)
        self.dfsRight(root.left, level+1)



    
    
        