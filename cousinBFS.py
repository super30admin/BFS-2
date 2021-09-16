# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# BFS
# TC O(n)
# SC O(n)
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        if root is None:
            return False
        que = deque([])
        que.append(root)
        
        while len(que) > 0:
            x_found = False
            y_found = False
            size = len(que)
            for i in range(size):
                root = que.popleft()
                if root.val == x:
                    x_found = True
                if root.val == y:
                    y_found = True
                if (root.right is not None) and (root.left is not None):
                    if (root.right.val == x and root.left.val == y) or (root.right.val == y and root.left.val == x ):
                        return False
                if root.right is not None:
                    que.append(root.right)
                if root.left is not None:
                    que.append(root.left)
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
                
                
        
