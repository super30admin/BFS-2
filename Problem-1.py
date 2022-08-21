#199. Binary Tree Right Side View

'''
Leetcode all test cases passed: Yes
Solution:
    def rightSideView(self, root):
        h is the height of the tree
        n is the no of nodes in the tree
        Time Complexity: O(n) 
        Space Complexity: O(h)
'''
from collections import deque
class Solution:
    def rightSideView(self, root):
        if not root:
            return []
        self.res = []
        self.helper(root,0)
        return self.res
    
    def helper(self,root,level):
        if not root:
            return
        
        if len(self.res) == level:
            self.res.append(root.val)
        self.helper(root.right,level + 1)
        self.helper(root.left,level + 1)
