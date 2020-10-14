# Time complexity - O(N)
# Space complexity - O(N)

# Ran on Leetcode - Yes


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        
        if root==None:
            return False
            
        
        x_rel = (None,None)
        y_rel = (None,None)
        
        queue = [(root,None)]
        
        depth = 0
        while queue:
            
            size = len(queue)
            
            for i in range(size):
                
                node, parent = queue.pop(0)
                
                if node.val==x and parent!=None:
                    x_rel = (depth, parent.val)
                    
                if node.val==y and parent!=None:
                    y_rel = (depth, parent.val)
                
                
                left = node.left
                right = node.right
                
                if left!=None:
                    queue.append((left,node))
                if right!=None:
                    queue.append((right,node))
                    
            depth += 1    
            
        if x_rel[0] == y_rel[0] and x_rel[1]!=y_rel[1]:
            return True
        
        return False
