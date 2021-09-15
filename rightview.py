# // Time Complexity :O(n) 
# // Space Complexity :O(h)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result=[]
        
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        if root==None:
            return root
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level):
        if root is None:
            return
        if level==len(self.result):
            self.result.append(root.val)
        else:
            self.result[level]=root.val
        self.dfs(root.left,level+1)
        self.dfs(root.right,level+1)
        