# Created by Aashish Adhikari at 8:34 PM 1/21/2021
'''
Time Complexity:
O(n) as we reach all the nodes.

Space Complexity:
O(n/2) as we are storing all the nodes of the same generation in the queue and the last level has n/2 nodes in a complete binary tree.
'''

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


        from collections import deque

        level = deque()
        level.append(root)


        while len(level) != 0:

            leng = len(level)

            # set for this level
            cousins = set()

            for idx in range(0, leng):
                node = level[0]

                if node.left is not None and node.right is not None:
                    if node.left.val == x and node.right.val == y or node.left.val == y and node.right.val == x:
                        # siblings, not cousins
                        return False
                    else:
                        cousins.add(node.left.val)
                        cousins.add(node.right.val)

                        level.append(node.left)
                        level.append(node.right)
                elif node.left is not None:
                    level.append(node.left)
                    cousins.add(node.left.val)
                elif node.right is not None:
                    level.append(node.right)
                    cousins.add(node.right.val)

                else:
                    pass

                level.popleft()


            if x in cousins and y in cousins:
                return True
            elif x in cousins:
                return False
            elif y in cousins:
                return False
            else:
                pass

        return False




