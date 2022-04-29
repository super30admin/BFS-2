#Time Complexity :o(n)
# Space Complexity :o(n)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no 
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        if not root.left and not root.right:
            return True
                
        left_height = self.height_helper(root.left)
        right_height = self.height_helper(root.right)
        
        
        return self.isBalanced(root.left) and self.isBalanced(root.right) and abs(left_height - right_height) <= 1
        

        
    def height_helper(self, root):
        if not root:
            return 0
        
        if not root.left and not root.right:
            return 1
        
        
        left = self.height_helper(root.left)
        
        right = self.height_helper(root.right)
        
        return max(left, right) + 1