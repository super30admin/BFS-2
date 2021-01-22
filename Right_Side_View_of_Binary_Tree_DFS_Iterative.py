# Created by Aashish Adhikari at 8:02 PM 1/21/2021

'''
Time Complexity:
O(n) as we reach each node once in inorder traversal.

Space Complexity:
The maximum number of elements in the used stack will be the height of the tree. O(h)
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

        recursive_stack = deque()
        level = 0
        while root is not None or len(recursive_stack) != 0:

            # traverse to the right
            while root is not None:

                if len(sol) == level:
                    sol.append(root.val)

                recursive_stack.append((root, level))
                level += 1
                root = root.left


            root, level = recursive_stack.pop()
            sol[level] = root.val

            if root.right is not None:
                level += 1
                root = root.right
            else:
                # If you do the following, you will make root is not None in the next iteration, infinite looping occurs.
                #root, level = recursive_stack.pop()
                root = root.right


        return sol




