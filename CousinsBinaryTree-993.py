# Time Complexity : O(n)
# Space Complexity : O(n) recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Declare parents and depth of both the nodes and check whether depth is same and parents are different
class Solution(object):
    def isCousins(self, root, x, y):

        if root is None:
            return
        
        
        def checkCousin(root, x, y , parent, depth):
            if root is None:
                return
            
            if root.val == x:
                self.parentX = parent
                self.depthX = depth
            elif root.val == y:
                self.parentY = parent
                self.depthY = depth
            
            # if self.depthX != -1 and self.depthY != -1:
            #     return
            checkCousin(root.left, x, y, root, depth + 1)
            checkCousin(root.right, x, y, root, depth + 1)
            
        
        self.parentX, self.parentY = None, None
        self.depthX, self.depthY = -1, -1
        checkCousin(root, x, y, None, 0)
        
        
        return self.depthX == self.depthY and self.parentX != self.parentY
