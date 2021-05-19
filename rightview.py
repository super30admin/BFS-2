"""Binary Tree Right Side View

Time Complexity - 0(N)
Space Complexity -O(H)
Approach - use dfs. start from right subtree then go to left. when len(result)==level add the element to the result"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result =[]
        
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return self.result
        self.dfs(root,0)
        return self.result
        
    def dfs(self,node: TreeNode, level: int) -> None:
        if node is None:
            return
        if level ==len(self.result):
            self.result.append(node.val)
        self.dfs(node.right,level+1)
        self.dfs(node.left,level+1)
            
        