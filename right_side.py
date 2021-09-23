#Time Complexity : O(n)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No




# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = []
    def dfs(self, root, lvl):
        #base
        if root == None:
            return
        if len(Solution.result) == lvl:
            Solution.result.append(root.val)
        
        #recurssive calls
        self.dfs(root.right, lvl+1)
        self.dfs(root.left, lvl+1)
        
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        Solution.result = []
        if root == None:
            return
        self.dfs(root, 0)
        return Solution.result