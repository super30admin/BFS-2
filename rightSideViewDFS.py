# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        
        if root is None:
            return None
        
        self.dfs(root, 0)
        
        return self.result
        
        
    def dfs(self, root: TreeNode, level: int):
        
         #base
            if root is None:
                return None
            
            #logic
            if level == len(self.result):
                self.result.append(root.val)

            
            self.dfs(root.right, level+1)
            self.dfs(root.left, level+1)
            
#  DFS solution.
            

            
        
            
            
    
        
        
