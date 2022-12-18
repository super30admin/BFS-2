""" 
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Time Complexity: O(n)
Space Complexity: O(n)

"""
from collections import deque
def rightSideView(root):
    if not root:
        return []
    
    queue = deque()
    queue.append(root)
    result = []
    
    while queue:
        size = len(queue)
        
        for i in range(size):
            node = queue.popleft()
            
            if i == size - 1:
                result.append(node.val)
            
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
                
                
    return result
        
        