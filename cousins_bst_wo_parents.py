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
        q.append(root)
        
        while len(q) != 0:
            size = len(q)
            i = 0
            x_found = False
            y_found = False
            while i < size:
                node = q.pop()
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True
                    
                if node.left is not None and node.right is not None:
                    if node.left.val == x and node.right.val  == y:
                        return False
                    if node.left.val  == y and node.right.val  == x:
                        return False
                    
                if node.left is not None:
                    q.appendleft(node.left)

                if node.right is not None:
                    q.appendleft(node.right)

                i += 1
                    
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
            
        return False