# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
"""
1. Traverse the tree with depth and previous node.
2. Encounter x or y, we store depth and the parent
3. compare the depth and parent and return result
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    depthx = depthy = -1
    parentx = parenty = None
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        self.helper(root, x, y, None, 0)
        
        if self.depthx == self.depthy and self.parentx != self.parenty: return True
        else: return False
        
    def helper(self, root, x, y, parent, depth):
        if root == None: return None
        
        if root.val == x:
            self.depthx = depth
            self.parentx = parent
            
        elif root.val == y:
            self.depthy = depth
            self.parenty = parent
        
        if self.depthx != -1 and self.depthy != -1: return None
        
        self.helper(root.left, x, y, root, depth+1)
        self.helper(root.right, x, y, root, depth+1)