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

        #         from collections import deque
        #         q=deque()
        #         q.append(root)
        #         while q:
        #             length=len(q)
        #             x_found=False
        #             y_found=False
        #             for i in range(length):
        #                 popp=q.popleft()
        #                 if popp.val==x:
        #                     x_found=True
        #                 if popp.val==y:
        #                     y_found=True
        #                 if popp.left!=None and popp.right!=None:
        #                     if (popp.left.val==x and popp.right.val==y) or (popp.right.val==x and popp.left.val==y):
        #                         return False
        #                 if popp.left!=None:
        #                     q.append(popp.left)
        #                 if popp.right!=None:
        #                     q.append(popp.right)

        #             if x_found and y_found:
        #                 return True
        #         return False
        # TIME-o(N) space-o(n)
        # dfs

        def dfs(child, parent, level, x, y):
            if child == None:
                return
            if child.val == x:
                x_depth = level
                x_parent = parent
            if child.val == y:
                y_depth = level
                y_parent = parent
            dfs(root.left, root, level + 1, x, y)
            dfs(root.right, root, level + 1, x, y)

        dfs(root.left, root, 0, x, y)
        return x_parent != y_parent and x_dept == y_depth