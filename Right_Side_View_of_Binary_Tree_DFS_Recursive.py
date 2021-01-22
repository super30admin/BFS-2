# Created by Aashish Adhikari at 7:21 PM 1/21/2021

'''
Time Complexity:
O(n) as we reach each node once in inorder traversal.

Space Complexity:
If we consider the recursive stack that is being used under the hood, O(height of the tree), else O(1)
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):


    def helper(self, node, level):


        # work on the current root
        if len(self.sol) == level:
            self.sol.append(node.val)
        else:
            self.sol[level] = node.val

        # work on the left child
        if node.left is not None:
            self.helper(node.left, level+1)



        # work on the right child
        if node.right is not None:
            self.helper(node.right, level+1)


    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        if root is None:
            return []

        self.sol = []

        self.helper(root, 0)


        return self.sol
