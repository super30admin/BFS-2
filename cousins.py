# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
    # started copying values backwards, using slow and fast pointer, fast is always one step ahead



class Solution:
    def helper(self, root, x, y, parent, depth):
        if(root==None):
            return
        if(root.val==x):
            self.x_depth=depth
            self.x_parent=parent
        if(root.val==y):
            self.y_depth=depth
            self.y_parent=parent
        self.helper(root.left, x, y, root, depth+1)
        self.helper(root.right, x, y, root, depth+1)

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_parent=None
        self.y_parent=None
        self.x_depth=0
        self.y_depth=0

        self.helper(root.left, x, y, root, 1)
        self.helper(root.right,x, y, root, 1)

        if(self.x_parent!=self.y_parent and self.x_depth==self.y_depth):
            return True
        return False