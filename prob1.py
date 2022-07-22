# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if(root == None):
            return []
        self.result = []
        self.dfs(root,0)
        return self.result
        
    def dfs(self,root,lvl):
        if(root == None):
            return
        
        if(lvl == len(self.result)):
            self.result.append(root.val)
        else:
            self.result[lvl]=self.result[lvl]
        self.dfs(root.right,lvl+1)
        self.dfs(root.left,lvl+1)
        