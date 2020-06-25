#LC 993 - Cousins in Binary Tree
#Time Complexity - O(n)
#Space Complexity - O(h)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        xd = []
        def getLevelParent(root,par,level,target):
            if not root:
                return None
            if root.val == target:
                xd.append([level,par])
            getLevelParent(root.left,root,level+1,target)
            getLevelParent(root.right,root,level+1,target)
        getLevelParent(root,None,0,x)
        getLevelParent(root,None,0,y)
        return xd[0][0] == xd[1][0] and xd[1][1] != xd[0][1]