'''
// Time Complexity : 0(n) -- end up traversing all the nodes
// Space Complexity : 0(h) -- height of the tree 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
'''

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def dfsWay(self,node,lvl):
        
        # base-case
        if node == None:
            return
        
        # logic-case
        if len(self.resultList) == lvl:
            # lvl index doesn't exist
            self.resultList.append(None)
        
        # update the value
        self.resultList[lvl] = node.val
        
        # recursive call on lhs
        self.dfsWay(node.left,lvl+1)
        
        # recursive call on rhs
        self.dfsWay(node.right,lvl+1)
        
        
        
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        # base-check
        if root == None:
            return self.resultList
        
        # Initialize lvl
        lvl = 0
        
        # recursive-call dfsWay
        self.dfsWay(root,lvl)
        
        # return the resulList
        return self.resultList
        