# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#APPROACH : BFS using 2 queues.1st for level order traversal and second for maintianing the parents
#Time Complexity : O(n)
#Space Complexity : O(n)
#Did your code run on leetcode: yes
from collections import deque
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque()
        parent_queue = deque()
        
        queue.append(root)
        parent_queue.append(None)
        
        x_found = False
        y_found = False
        x_parent = None
        y_parent = None
        
        while(len(queue) != 0):
            size = len(queue)
            
            for i in range(size):
                current = queue.popleft()
                parent = parent_queue.popleft()
                
                if (current.val == x):
                    x_found = True
                    x_parent = parent
                
                if (current.val == y):
                    y_found = True
                    y_parent = parent
                    
                if(current.left != None): 
                    queue.append(current.left)
                    parent_queue.append(current)
                
                if(current.right != None): 
                    queue.append(current.right)
                    parent_queue.append(current)
                    
            if x_found == y_found and x_parent != y_parent:
                return True
            if x_found != y_found: return False
                
