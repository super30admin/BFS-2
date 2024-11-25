# TC: O(n)
# SC: O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []
        
        def dfs(root, depth):
            if root is None:
                return
            
            if depth == len(self.res):
                self.res.append(root.val)


            dfs(root.right, depth + 1)
            dfs(root.left, depth + 1)
            
        dfs(root, 0)
        return self.res



        
