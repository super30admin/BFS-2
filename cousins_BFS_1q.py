# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#APPROACH : BFS using 1 queue for level order traversal.
#Time Complexity : O(n)
#Space Complexity : O(n)
#Did your code run on leetcode: yes

from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque()
        
        queue.append(root)
        
        x_found = False
        y_found = False
        
        while(len(queue) != 0):
            size = len(queue)
            
            for i in range(size):
                current = queue.popleft()
                if (current.val == x):
                    x_found = True
                
                if (current.val == y):
                    y_found = True
                
                if current.left != None and current.right != None:
                    if current.left.val == x and current.right.val == y: return False
                    if current.left.val == y and current.right.val == x: return False

                if(current.left != None): 
                    queue.append(current.left)
                   
                if(current.right != None): 
                    queue.append(current.right)
                    
            if x_found and y_found: return True
            if x_found  or y_found: return False
                
