# 993. Cousins in Binary Tree

'''
Leetcode all test cases passed: Yes
Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        h is the height of the tree
        n is the no of nodes in the tree
        Time Complexity: O(n) 
        Space Complexity: O(h)
'''
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.val_1 = x
        self.val_2 = y
        self.x,self.y = [None,None],[None,None]
        if not root:
            return []
        
        self.helper(root,0,root.val)
        return self.x[1] != self.y[1] and self.x[0] == self.y[0]
    
    def helper(self,root,level,parent):
        if not root:
            return
        
        if root.val == self.val_1:
            self.x = [level,parent]
        if root.val == self.val_2:
            self.y = [level,parent]
            
        self.helper(root.right,level + 1,root.val)
        self.helper(root.left,level + 1,root.val)
