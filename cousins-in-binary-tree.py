# Time Complexity: O(n)
# Space Complexity: O(n)
# Approach:
# Do a level order traversal. At each level, keep a track of whether the left/right children of the nodes are equal to x or y.
# Set px, py as parent of x/y at each level. After the level is processed, check if either px or py is found in the level.
# If either parent is found, check if the other parent is also found in the same level and also px != py.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        q = collections.deque([root])
        
        
        while q:
            numnodes = len(q)
            px, py = None, None
            for _ in range(numnodes):
                node = q.popleft()
                if node.left:
                    if node.left.val == x:
                        px = node
                    if node.left.val == y:
                        py = node
                    q.append(node.left)
                    
                if node.right:
                    if node.right.val == x:
                        px = node
                    if node.right.val == y:
                        py = node
                    q.append(node.right)
                    
            if px or py:
                return px is not None and py is not None and px != py
                    