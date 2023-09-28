# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root):
        if not root:
            return root
        
        res = []
        def dfs(root, level):
            if not root:
                return
            if level == len(res):
                res.append(root.val)
            dfs(root.right, level+1)
            dfs(root.left, level+1)

        dfs(root, 0)
        return res
    
#TC: O(n)
#SC: O(h)