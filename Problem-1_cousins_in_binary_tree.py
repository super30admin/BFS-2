# APPROACH 1: BFS NAIVE
# Time Complexity : O(n), n: number of nodes of BT
# Space Complexity : O(n) actually O(3n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do BFS traversal
# 2. Along with each node store it's parent and level
# 3. Have a flag if x and y is found, then check if their parents are not same but are of same level -> TRUE. else -> FALSE

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if root is None:
            return True
        
        queue, x_found, x_parent, x_level, y_found, y_parent, y_level  = deque(), False, None, -1, False, None, -1
        queue.append((root, None, 0))
        
        while len(queue) > 0:
            element = queue.popleft()
            node, level, parent = element[0], element[2], element[1]
            
            if node.val == x:
                x_found, x_parent, x_level = True, parent, level
            elif node.val == y:
                y_found, y_parent, y_level = True, parent, level
                
            if x_found and y_found:
                if x_parent != y_parent and x_level == y_level:
                    return True
                else:
                    return False
             
            if node.left is not None:
                queue.append((node.left, node, level + 1))
            if node.right is not None:
                queue.append((node.right, node, level + 1))
            
        
        return False
            
            
            
            

# APPROACH 2: BFS OPTIMAL
# Time Complexity : O(n), n: number of node in BT
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do BFS traversal
# 2. Before adding any node to the queue, check if both of i's children are x and y. If so, return False else, add them
# 3. In a level (by maintaining size local variable), check if x and y found at same level

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if root is None or root.val == x or root.val == y:
            return False
        
        queue, x_found, y_found  = deque(), False, False
        queue.append(root)
        
        while len(queue) > 0:
            size = len(queue)
            
            while size > 0:
                node = queue.popleft()
                if node.val == x:
                    x_found = True
                elif node.val == y:
                    y_found = True
                    
                if node.left is not None and node.right is not None and ((node.left.val == x and node.right.val == y) or (node.right.val == x and node.left.val == y)):
                    return False
                    
                if node.left is not None:
                    queue.append(node.left)
                    
                if node.right is not None:
                    queue.append(node.right)
                    
                size -= 1
                    
            if x_found and y_found:
                return True
            elif x_found or y_found:
                return False
            
        return False
            
            
            
            
            
            

# APPROACH  3: DFS (INEFFICIENT, as it does the whole traversal despite being present at earlier levels)
# Time Complexity : O(n), n: number of nodes of BT
# Space Complexity : O(h), h: height of BT
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do whole DFS traversal
# 2. If any node's value is same as x, store the parent and level. Similarly for y
# 3. Parent and level for each node are maintained locally
# 4. check if their parents are not same but are of same level -> TRUE. else -> FALSE


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.x_parent, self.x_level = None, -1
        self.y_parent, self.y_level = None, -1
        
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        if root is None or root.val == x or root.val == y:
            return False
        
        self.dfs(root, None, 0, x, y)
        
        if self.x_parent != self.y_parent and self.x_level == self.y_level:
            return True
        else:
            return False
        
        
    def dfs(self, root, parent, level, x, y):
        if root is None:
            return 
        
        if root.val == x:
            self.x_parent, self.x_level = parent, level
            
        if root.val == y:
            self.y_parent, self.y_level = parent, level
            
        self.dfs(root.left, root, level + 1, x, y)
        self.dfs(root.right, root, level + 1, x, y)
            
        
            
        
        
            
