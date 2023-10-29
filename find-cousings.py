# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# DFS : TC: O(n)
# SC: O(height of recursion stack)

# Approach 1 - DFS boolean based recursion
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """

        def helper(root, level, parent):

            if root is None:
                return

            if root.val == x:
                # print("X found: ", root.val, level, parent)
                self.depthX = level
                self.parentX = parent

            if root.val == y:
                # print("Y found: ", root.val, level, parent)
                self.depthY = level
                self.parentY = parent

            if self.parentX != None and self.parentY != None and self.parentX != self.parentY and self.depthX == self.depthY:
                self.flagX = self.flagY = True

            if self.flagX is False or self.flagY is False:
                helper(root.left, level + 1, root.val)

            if self.flagX is False or self.flagY is False:
                helper(root.right, level + 1, root.val)

        self.flagX = False
        self.flagY = False

        self.depthX = None
        self.depthY = None
        self.parentX = None
        self.parentY = None
        helper(root, 0, None)
        return self.flagX and self.flagY
        # print (self.parentX, self.parentY)
        # print (self.depthX, self.depthY)
        # if self.parentX != self.parentY and self.depthX == self.depthY:
        #     return True
        # else:
        #     return False

# Approach 2 - DFS void based recursion

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

        def helper(root, level, parent):

            # base
            if root is None:
                return

            # logic
            if root.val == x:
                print("X found: ", root.val, level, parent)
                self.depthX = level
                self.parentX = parent

            if root.val == y:
                print("Y found: ", root.val, level, parent)
                self.depthY = level
                self.parentY = parent

            # left
            helper(root.left, level + 1, root.val)
            # right
            helper(root.right, level + 1, root.val)

        self.depthX = None
        self.depthY = None
        self.parentX = None
        self.parentY = None
        helper(root, 0, None)
        if self.parentX != self.parentY and self.depthX == self.depthY:
            return True
        else:
            return False

       # BFS

        # TC: O(n)
        # SC: O(2n) = O(n)

        # q = []  # queue to maintain visited nodes
        # pq = []  # queue to maintain parents of visited nodes

        # q.append(root)
        # pq.append(None)

        # parentX = None
        # parentY = None
        # xFound = False
        # yFound = False
        # while len(q) != 0:
        #     size = len(q)  # keep track of level

        #     for i in range(size):
        #         # pop node from both queues, see if they equal x or y. If yes for either x or y found, record parents. Eventually, after the level ends, see if both were found. If yes, see if their parents are same or not. If yes, return False else return True
        #         currNode = q.pop(0)
        #         parent = pq.pop(0)

        #         if currNode.val == x:
        #             xFound = True
        #             parentX = parent

        #         if currNode.val == y:
        #             yFound = True
        #             parentY = parent

        #         if currNode.left != None:
        #             q.append(currNode.left)
        #             pq.append(currNode)

        #         if currNode.right != None:
        #             q.append(currNode.right)
        #             pq.append(currNode)

        #     if xFound and yFound:
        #         if parentX == parentY:
        #             return False
        #         return True  # because we are doing this right after level ends, this ensures they are from the same level

        #     # if only one of them is found in a given level, break and return False. No need to search for the other variable.
        #     if xFound == True or yFound == True:
        #         return False

        # return False
