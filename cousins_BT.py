# Time Complexity : Add - O(N)
# Space Complexity :O(h), h being the height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used used DFS to calcluate parent and level of both x and y
2. Then compare the result in main function
'''

class Solution:
    
    def __init__(self):
        
        self.xLevel = None
        self.yLevel = None
        
        self.xParent = None
        self.yParent = None
        
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        self._helper(root, -1, None, x, y)
                
        if self.xLevel > 0 and self.yLevel > 0:
            if self.xLevel == self.yLevel and self.xParent != self.yParent:
                return True
        
        return False
            
    #DFS
    def _helper(self, root, level, parent, x,y):
        
        if root is None:
            return
        
        level += 1
        
        if root.val == x:
            self.xLevel = level
            self.xParent = parent
            
        elif root.val == y:
            self.yLevel = level
            self.yParent = parent
            
          
        self._helper(root.left, level, root, x, y)
        self._helper(root.right, level, root, x, y)
            