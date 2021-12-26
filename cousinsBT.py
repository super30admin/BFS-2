# // Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    dx = 0
    px = 0
    dy = 0
    py = 0
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        def findDepth(root,x,y,depth,parent):
            if root:
                if root.val == x:
                    self.dx = depth
                    self.px = parent
                    # print(dx)
                if root.val == y:
                    self.dy = depth
                    self.py = parent
                    # print(dy)

                findDepth(root.left,x,y,depth+1,root.val)
                findDepth(root.right,x,y,depth+1,root.val)




        # print(d1,d2)
        findDepth(root,x,y,0,0)
        # print(dx,px,dy,py)
        if self.dx==self.dy and self.px!=self.py:
            return True
        else:
            return False










