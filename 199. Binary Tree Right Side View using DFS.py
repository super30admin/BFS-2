# Solved using DFS
#Time and space complexity: O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result =[]
        self.dfs(root,0,result)
        return result
    
    def dfs(self, root: TreeNode, level: int, result: List[int]):
        #Base
        if root == None:
            return
        #Logic
        if len(result)==level:
            result.append(root.val)
        #left
        self.dfs(root.right,level+1,result)     #will go to right side first
        self.dfs(root.left,level+1,result)
        
        