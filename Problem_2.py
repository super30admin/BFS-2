# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# DFS Approach
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = None
        self.y_parent = None
        self.x_flag = False
        self.y_flag = False
        self.dfs(root, None, 0, x, y)
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent
    
    def dfs(self, root: TreeNode, parent: TreeNode, depth: int, x: int, y: int) -> None:
        if root == None:
            return
        if x == root.val:
            self.x_depth = depth
            self.x_parent = parent
            self.x_flag = True
            
        if y == root.val:
            self.y_depth = depth
            self.y_parent = parent
            self.y_flag = True
            
        self.dfs(root.left, root, depth + 1, x, y)
        if not (self.y_flag and self.x_flag):
            self.dfs(root.right, root, depth + 1, x, y)

# Time Complexity: O(n)
# Space Complexity: O(h)


# BFS Approach
import queue
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = queue.Queue()
        q.put(root)
        while not q.empty():
            size = q.qsize()
            x_found = False
            y_found = False
            for i in range(size):
                curr = q.get()
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left != None and curr.right!= None:
                    if (curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x):
                        return False
                if curr.left != None:
                    q.put(curr.left)
                if curr.right != None:
                    q.put(curr.right)
                    
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        
        return False

# Time Complexity: O(n)
# Space Complexity: O(n)