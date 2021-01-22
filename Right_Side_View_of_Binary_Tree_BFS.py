# Created by Aashish Adhikari at 7:06 PM 1/21/2021

'''
Time Complexity:
O(n) as we are reaching at each node once.

Space Complexity:
In the bfs queue, the max number of elements ~ no of elements in the last layer + 1
Hence, O(n/2) ~ O(n)
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """


        if root is None:
            return []


        sol = []
        from collections import deque

        level_order = deque()

        level_order.append(root)

        while len(level_order) != 0:

            size = len(level_order)

            for idx in range(size):

                node = level_order[0]


                if idx == size - 1:
                    sol.append(node.val)

                if node.left is not None:
                    level_order.append(node.left)

                if node.right is not None:
                    level_order.append(node.right)

                level_order.popleft()

        return sol





