# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC SC = O(n) O(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = [(root, None)]  # Queue with tuples (node, parent)
        while q:
            level = []  # store nodes and their parents at the current level
            for _ in range(len(q)):
                node, parent = q.pop(0)
                if node:
                    level.append((node.val, parent))
                    q.append((node.left, node))
                    q.append((node.right, node))
            
            # Check if x and y are at the current level
            x_parent = y_parent = None
            for val, parent in level:
                if val == x:
                    x_parent = parent
                if val == y:
                    y_parent = parent
            
            if x_parent and y_parent:
                # x and y are cousins if their parents are different
                return x_parent != y_parent
            if x_parent or y_parent:
                # If only one of them is found at this level, they are not cousins
                return False
        
        return False  # x and y are not found
