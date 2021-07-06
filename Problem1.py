# Time Complexity: O(N)
# Space Complexity: O(2^H) Height of the tree
# Passed Leetcode

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        queue = deque([[(root, None)]])
        
        while len(queue) > 0:
            
            nodes = queue.popleft()
            
            foundX = None
            foundY = None
            
            node_list = []
            for node in nodes:
                
                if node[0].val == x or node[0].val == y:
                    if node[0].val == x:
                        foundX = node[1]
                    
                    if node[0].val == y:
                        foundY = node[1]
                
                if node[0].left:
                    node_list.append((node[0].left, node[0].val))
                    
                if node[0].right:
                    node_list.append((node[0].right, node[0].val))
                
            if foundX or foundY:
                
                if (not foundX or not foundY) or foundX == foundY:
                    return False
                
                return True
            
            queue.append(node_list)
            
                
            
            