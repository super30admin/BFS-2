# DFS - Time - O(N) and Space - O(H), height

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    x_depth, y_depth = -1,-1
    x_parent, y_parent = None, None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False
        
        self.dfs(root, x, y, None, 0)
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent
    
    def dfs(self, root, x, y, parent, depth):
        if root is None:
            return
        
        if root.val == x:
            self.x_depth = depth
            self.x_parent = parent
        if root.val == y:
            self.y_depth = depth
            self.y_parent = parent
        
        self.dfs(root.left, x, y, root, depth + 1)
        self.dfs(root.right, x, y, root, depth + 1)


#BFS
# Time Complexity: O(N)
# Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return True
        
        q = list()
        q.append(root)
        while len(q) != 0:
            size = len(q)
            x_found, y_found = False, False
            for i in range(size):
                curr = q.pop(0)
                if curr.val == x: x_found = True
                if curr.val == y: y_found = True
                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y: return False
                    if curr.left.val == y and curr.right.val == x: return False
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if x_found and y_found: return True
            if x_found or y_found: return False
        return False


#BFS
# Time Complexity: O(N)
# Space Complexity: O(N)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return True
        
        q = list()
        parent_q = list()
        q.append(root)
        parent_q.append(TreeNode())
        while len(q) != 0:
            size = len(q)
            x_found, y_found = False, False
            x_parent, y_parent = None, None
            for i in range(size):
                curr = q.pop(0)
                currP = parent_q.pop(0)
                if curr.val == x:
                    x_found = True
                    x_parent = currP
                if curr.val == y:
                    y_found = True
                    y_parent = currP
                if curr.left:
                    q.append(curr.left)
                    parent_q.append(curr)
                if curr.right:
                    q.append(curr.right)
                    parent_q.append(curr)
            if x_found and y_found: return x_parent != y_parent
            if x_found or y_found: return False
        return False