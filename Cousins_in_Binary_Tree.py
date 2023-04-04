# Time Complexity : O(n) where n : number of nodes
# Space Complexity : O(n) where n : number of nodes

# Definition for a binary tree node.
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        queue = deque([(root, None, 0)]) # (node, parent, depth)
        x_info, y_info = None, None
        
        while queue:
            node, parent, depth = queue.popleft()
            
            if node.val == x:
                x_info = (parent, depth)
                
            elif node.val == y:
                y_info = (parent, depth)
            
            if x_info and y_info:
                break
                
            if node.left:
                queue.append((node.left, node, depth+1))
                
            if node.right:
                queue.append((node.right, node, depth+1))
                
        if x_info[0] != y_info[0] and x_info[1] == y_info[1]:
            return True
        
        return False