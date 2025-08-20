# Cousins in Binary Tree
# We are using DFS to traverse the tree level by level, checking if both nodes are found at the same level without being siblings.
# If one of the nodes is found and the other is not, we return False.
# Time Complexity: O(n)
# Space Complexity: O(n), for the queue used in BFS traversal.

from collections import deque

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#from collections import dequeue
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque([root])
        xfound,yfound = False, False
        while queue:
            for i in range(len(queue)):
                node = queue.popleft()
                if node.val == x:
                    xfound = True
                if node.val == y:
                    yfound = True
                if node.left and node.right:
                    # Checking of the values are siblings
                    if (node.left.val ==x and node.right.val == y) or (node.left.val ==y and node.right.val == x):
                        return False
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            if xfound and yfound: # both nodes found at the same level
                return True
            if xfound or yfound: # only one node found at this level
                return False
                    




        