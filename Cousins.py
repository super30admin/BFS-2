#Time Complexity:O(n)
#Space Complexity:O(n)
#Leetcode Submission:Successful
#We keep global variable of depth and parents  and run a dfs
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.x_depth=-1
        self.y_depth=-1
        self.x_parent=None
        self.y_parent=None
        self.helper(root,x,y,0,None)
        return self.x_depth == self.y_depth and self.x_parent!=self.y_parent
    def helper(self,Noder,x,y,depth,Nodep):
        if not Noder:
            return 
        if Noder.val==x:
            self.x_depth=depth
            self.x_parent=Nodep
        if Noder.val==y:
            self.y_depth=depth
            self.y_parent=Nodep
        self.helper(Noder.left,x,y,depth+1,Noder)
        self.helper(Noder.right,x,y,depth+1,Noder)

                