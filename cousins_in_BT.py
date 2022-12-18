""" 
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.


Time Complexity: O(n)
Space Complexity: O(n)
"""

from collections import deque
def isCousins(root, x, y):
    
    queue = deque()
    queue.append(root)
    
    while queue:
        size = len(queue)
        x_found = False
        y_found = False
        
        for i in range(size):
            node = queue.popleft()
            
            if node.val == x:
                x_found = True
            if node.val == y:
                y_found = True
                
            if node.left and node.right:
                if node.left.val == x and node.right.val == y:
                    return False
                if node.left.val == y and node.right.val == x:
                    return False
                
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
                
        if x_found and y_found:
            return True
        
    return False