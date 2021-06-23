# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(h)
from collections import deque


class Solution(object):
    is_x = False
    x_p = None
    is_y = False
    y_p = None
    l_x = 0
    l_y = 0

    def bfsCousin(self, root, x, y):
        #       Mainatin 2 queue

        cq = deque()
        nq = deque()
        #         append root to next queue
        nq.append(root)
        #         iterate in next queue untill we hit null
        while nq:
            #         assign  current queue to next level queue and next to empty queue
            cq = nq
            nq = deque()
            #             until current queue is not null
            while cq:
                #         get first element in queue
                c = cq.popleft()
                #                 if left is present check if left val is either x or y
                # if so then we update the flag for x or y to True and updat eits parents
                #     same will happen for right
                # and append it to the next level queue whether we found the match or not
                if c.left:
                    if c.left.val == x:
                        self.is_x = True
                        self.x_p = c
                    elif c.left.val == y:
                        self.is_y = True
                        self.y_p = c
                    nq.append(c.left)
                if c.right:
                    if c.right.val == x:
                        self.is_x = True
                        self.x_p = c
                    elif c.right.val == y:
                        self.is_y = True
                        self.y_p = c
                    nq.append(c.right)
            #             at the end of the current level queue we will check if we got our required cousins if not then we will reset the global variables
            if self.is_x and self.is_y and (self.x_p != self.y_p):
                return True
            elif self.is_x or self.is_y:
                return False

        return False

    def dfsCousin(self, root, x, y, level, parent):
        #       Base condition
        if not root:
            return
        #       logic
        if root.val == x:
            self.is_x = True
            self.x_p = parent
            self.l_x = level
        elif root.val == y:
            self.is_y = True
            self.y_p = parent
            self.l_y = level

        if self.is_x and self.is_y and (self.x_p != self.y_p) and (self.l_x == self.l_y):
            return True

        return self.dfsCousin(root.left, x, y, level + 1, root) or self.dfsCousin(root.right, x, y, level + 1, root)

    def dfsCousinMain(self, root, x, y):
        if not root:
            return True
        return self.dfsCousin(root, x, y, 0, None)
        # if self.is_x and self.is_y and (self.x_p != self.y_p) and (self.l_x == self.l_y):
        #     return True
        # return False

    def isCousins(self, root, x, y):

        # return self.bfsCousin(root,x,y)
        return self.dfsCousinMain(root, x, y)
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
