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
                    