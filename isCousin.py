# TC: O(n)
# SC: O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.depth_x = -1
        self.parent_x = None
        self.depth_y = -1
        self.parent_y = None

        if not root or not x or not y:
            return False

        def helper(root, nodeVal1, nodeVal2, depth, parent):
            if root is None:
                return
            
            if root.val == nodeVal1:
                self.depth_x = depth
                self.parent_x = parent
            
            if root.val == nodeVal2:
                self.depth_y = depth
                self.parent_y = parent
            
            helper(root.left, nodeVal1, nodeVal2, depth+1, root)
            helper(root.right, nodeVal1, nodeVal2, depth+1, root)
        
        helper(root, x, y, 0, None)
 
        if self.depth_x == self.depth_y:
            if self.parent_x != self.parent_y:
                return True
            return False
        return False
