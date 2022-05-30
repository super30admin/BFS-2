'''
time complexity: O(n)
space complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None: return []
        res = []
        def dfs(root,res,level):
            if root is None: return
            if(len(res)==level):
                res.append(root.val)
            dfs(root.right,res,level+1)
            dfs(root.left,res,level+1)
        dfs(root,res,0)
        return res
        