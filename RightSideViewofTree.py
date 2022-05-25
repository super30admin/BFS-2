#Time complexity: O(n)
#Space complexity:O(h) height of the tree
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    res=[]
    def rightSideView(self, root):
        self.res=[]
        self.helper(root,0)
        return self.res
    def helper(self,root,level):
        if not root:
            return
        if level== len(self.res):
            self.res.append(root.val)
        self.helper(root.right,level+1)
        self.helper(root.left,level+1)
        