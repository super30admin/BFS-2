"""
Time Complexity : isCousins_BFS - O(n)
                  isCousins_DFS - O(n)
Space Complexity : isCousins_BFS - O(n)
                   isCousins_DFS - O(1) [O(h) - stack space]
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

from queue import Queue

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isCousins_BFS(self, root: TreeNode, x: int, y: int) -> bool:
        if not root or not root.left or not root.left:
            return False
        
        q = Queue()
        q.put(root)
        
        while not q.empty():
            size = q.qsize()
            x_found = False
            y_found = False
            
            for i in range(size):
                node = q.get()
                if node.left and node.right:
                    if node.left.val == x and node.right.val == y or node.left.val == y and node.right.val == x:
                        return False
                if node.val == x:
                    x_found = True
                if node.val == y:
                    y_found = True           
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
                    
            if x_found and y_found:
                    return True
                
                
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        
        self.dfs(root, None, 0, x, y)
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent
        
    def dfs(self, root, parent, depth, x, y):
        # base case
        if not root:
            return
        
        # recursive case
        if root.val == x:
            self.x_parent = parent
            self.x_depth = depth
            
        if root.val == y:
            self.y_parent = parent
            self.y_depth = depth
        
        self.dfs(root.left, root, depth + 1, x, y)
        self.dfs(root.right, root, depth + 1, x, y)
            