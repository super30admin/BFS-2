#Time, space complexity O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.res=[]
        self.dfs(root,0)
        return self.res
    
  #Applying preorder traversal  
    def dfs(self,root,h):
        
        if root == None:
            return None
        #At each level appending the rightmost child
        if len(self.res)==h:
            self.res.append(root.val)
            
        self.dfs(root.right,h+1)
        self.dfs(root.left,h+1)
