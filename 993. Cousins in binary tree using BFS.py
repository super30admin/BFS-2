# Time and space complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from queue import Queue
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = Queue() # Queue for current node
        pq = Queue() # Queue for parents
        # Initially
        q.put(root)
        pq.put(None)

        while not q.empty():
            size = q.qsize()
            x_found = False
            y_found = False
            x_parent = None
            y_parent = None
            for i in range(size): # For loop processes the level 
                curr = q.get()
                currP = pq.get()
                if curr.val == x:
                    x_found = True
                    x_parent = currP
                if curr.val == y:
                    y_found = True
                    y_parent = currP
                if curr.left is not None:
                    q.put(curr.left)
                    pq.put(curr)
                if curr.right is not None:
                    q.put(curr.right)
                    pq.put(curr)        # Level proccessing ends here
            if x_found and y_found and x_parent != y_parent: #if the nodes are on same level and their parents are not same, Cousins
                return True
            if x_found or y_found: # If we either get x or y in same level but not both, not cousins
                return False
        return False


