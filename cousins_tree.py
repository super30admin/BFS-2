
#Time Complexity: O(N).
#Auxiliary Space: O(h)
#Did this code successfully run on Leetcode :Yes

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
        self.xfound = False
        self.yfound = False
        self.xlevel = -1
        self.ylevel = -1
        self.xparent = 101
        self.yparent = 102
        
        def inorder(root,level,parent):
            if not root:
                return
            
            if self.xfound and self.yfound:
                return
            
            if root.val == x:
                self.xfound = True
                self.xparent = parent
                self.xlevel = level
            elif root.val == y:
                self.yfound = True
                self.yparent =parent
                self.ylevel = level
                
            inorder(root.left,level+1,root.val)
            inorder(root.right,level+1,root.val)
                
            
                
            
            
        inorder(root,0,None)
        return self.xfound == self.yfound and self.xparent!=self.yparent  and self.xlevel ==self.ylevel