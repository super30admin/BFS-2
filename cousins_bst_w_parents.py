# Time Complexity : O(N) where N is number of nodes in the tree
# Space Complexity : O(N) where N is number of nodes in the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        parentsQ = deque()
        
        q.append(root)
        parentsQ.append(None)
        
        while len(q) != 0:
            size = len(q)
            i = 0
            x_found = False
            y_found = False
            x_parent = None
            y_parent = None
            while i < size:
                node = q.pop()
                p = parentsQ.pop()
                if node.val == x:
                    x_found = True
                    x_parent = p
                if node.val == y:
                    y_found = True
                    y_parent = p
                    
                if node.left is not None:
                    q.appendleft(node.left)
                    parentsQ.appendleft(node)
                if node.right is not None:
                    q.appendleft(node.right)
                    parentsQ.appendleft(node)
                i += 1
                    
            if x_found and y_found: return x_parent != y_parent
            if x_found or y_found: return False
            
        return False