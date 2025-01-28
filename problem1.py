# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC SC - O(n) O(n)
class Solution:
    def rightSideView(self, root):
        if root == None: return []
        q = [root]
        res, l = [], 0
        while q:
            n = len(q)
            level = []
            for i in range(n):
                curr = q.pop(0)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
                level.append(curr.val)
                l += 1
            if level:
                res.append(level[-1])
        return res