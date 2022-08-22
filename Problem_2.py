"""
Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import defaultdict
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Using DFS, to find the values of x and y first; keeping track of x and y parent; 
        keeping track of x and y dept
        Time Complexity: O(N)
        Space Complexity : O(H)
        """
        if root is None:  return None
        self.x = x
        self.y = y
        self.x_parent = None
        self.y_parent = None
        self.x_depth, self.y_depth = 0,0
        def dfs_helper(root, parent, depth):
            #base Condition
            if root is None : return 
            
            #logic
            if root.val == self.x:
                self.x_parent = parent
                self.x_depth = depth
                
            if root.val == self.y:
                self.y_parent = parent
                self.y_depth = depth
            if root or root.left:    
                dfs_helper(root.left, root, depth + 1)
            if root or root.right:
                dfs_helper(root.right, root, depth + 1)
        
       
        dfs_helper(root,None, 0)
        
        return self.x_parent != self.y_parent and self.x_depth == self.y_depth


# Approach - 2

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import defaultdict

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Using BFS to traverse the tree. stopping befor the nodes x and y if the parent is same
        Time Complexity : O(N)
        Space Complexity : O(N)
        """
      
        queue = collections.deque([root])
       
        while queue:
            _size = len(queue)
            x_found = False
            y_found = False
            
            for i in range(_size):
                node = queue.popleft()
                if node.val == x: x_found = True
                if node.val == y: y_found = True
                 
                # Checking one level before if the x and y are siblings not cousins 
                if node.left and node.right :
                    if node.left.val == x and node.right.val == y : return False
                    if node.left.val == y and node.right.val == x : return False
                 
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            # if both the cousins are found return true    
            if x_found and y_found : return True        
            if x_found or y_found : return False
            
        return False
            
            
  
                    
                
                    
       
        
        