# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        xpar, ypar, xdep, ydep = None, None, 0, 0
        
        def dfs(node, x, y, depth, parent):
            
            if not node:
                return
            # print(node.val, x, depth)
            if node.val == x:
                # print('yeah')
                nonlocal xpar
                nonlocal xdep
                xpar = parent
                xdep = depth
                # print(xdep)
                # print(xpar.val)
            if node.val == y:
                # print('yeahh')
                nonlocal ypar
                nonlocal ydep
                ypar = parent
                ydep = depth
                # print(ydep)
                # print(ypar.val)
            dfs(node.left, x, y, depth+1, node)
            dfs(node.right, x, y, depth+1, node)
            
        dfs(root, x, y, 0, None)
        # print((xdep, ydep))
        if xpar and ypar and xpar != ypar and xdep == ydep:
            return True
        return False