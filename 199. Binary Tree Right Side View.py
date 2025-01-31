#space: O(h)
#time: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        self.qu= list()
        self.dfs(root,0)
        return self.qu
    
    def dfs(self,root,lvl):
        if root is None:
            return


        if lvl >= len(self.qu):
            self.qu.append(root.val)    
        self.dfs(root.right, lvl+1)
        self.dfs(root.left, lvl+1)
