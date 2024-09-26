# Time Complexity: -
# Space Complextiy: - 
# Tried, bur don't know how to solve it

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return []
        q = collections.deque()
        q.append(root)
        ans = []
        
        while q:
            q_size = len(q)
            level = []
            
            for i in range(q_size):