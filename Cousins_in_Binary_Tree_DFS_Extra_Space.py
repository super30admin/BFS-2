# Created by Aashish Adhikari at 9:48 PM 1/21/2021
'''
Time Complexity:
O(n) as we reach all the nodes once.

Space Complexity:
In the worst case, storing all the nodes in the sets, O(n)

'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

    def helper(self, node, level, x, y):

        if node.left is not None and node.right is not None:

            if node.left.val == x and node.right.val == y or node.left.val == y and node.right.val == x:
                return False

        if level not in self.hm:
            self.hm[level] = set()



        case1 = False
        case2 = False

        if node.left is not None:
            if node.left.val == x and y in self.hm[level]:
                return True
            if node.left.val == y and x in self.hm[level]:
                return True
            self.hm[level].add(node.left.val)
            case1 = self.helper(node.left, level+1, x, y)


        if node.right is not None:
            if node.right.val == x and y in self.hm[level]:
                return True
            if node.right.val == y and x in self.hm[level]:
                return True
            self.hm[level].add(node.right.val)
            case2 = self.helper(node.right, level+1, x, y)

        if case1 or case2:
            return True
        else:
            return False


    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """

        self.hm = {}


        case = self.helper(root, 1, x, y)

        if case == False:
            return False
        else:
            return True

