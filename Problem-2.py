"""
Approach: Apply DFS or BFS and check for the rules to be cousins:
1) the level should be same
2) the parent should not be same



TC: O(n)
SC: O(n)
"""

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Approach 1: BFS
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = deque()
        q.append((root, None))
        x_flag = False
        y_flag = False
        x_parent = False
        y_parent = False
        while q:
            size = len(q)
            x_flag = False
            y_flag = False
            for _ in range(size):
                curr = q.popleft()
                if curr[0].left: 
                    q.append((curr[0].left, curr[0]))

                if curr[0].right:
                    q.append((curr[0].right, curr[0]))
                
                if curr[0] and curr[0].val == x:
                    x_flag = True
                    x_parent = curr[1]
                
                if curr[0] and curr[0].val == y:
                    y_flag = True
                    y_parent = curr[1]
                
                if x_flag and y_flag and x_parent != y_parent:
                    return True
        return False

    # Approach 2: DFS
    """
    def __init__(self):
        self.result = False
        self.x_found = False
        self.y_found = False
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = None
        self.y_parent = None
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root  or root.val == x or root.val == y:
            return False
        self.helper(root, None, 0, x, y)
        return self.result
    
    def helper(self, root, parent, depth, x, y):
        #base
        if not root:
            return 
        #logic
        if x == root.val:
            self.x_found = True
            self.x_parent = parent
            self.x_depth = depth
        
        if y == root.val:
            self.y_found = True
            self.y_parent = parent
            self.y_depth = depth
        
        if self.x_found and self.y_found and self.x_depth == self.y_depth and self.x_parent != self.y_parent:
            self.result = True
        if not self.x_found or not self.y_found:
            self.helper(root.left, root, depth+1, x, y)
        if not self.x_found or not self.y_found:
            self.helper(root.right, root, depth+1, x, y)
        """