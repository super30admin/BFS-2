# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if root is None:
            return result
        
        def dfs(root,depth):
            if root==None:
                return
            if depth==len(result):
                result.append(root.val)
                
            dfs(root.right,depth+1)
            dfs(root.left,depth+1)
            
            return result
        
        return dfs(root,0)