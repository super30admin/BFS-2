# // Time Complexity : O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode : Yes
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

        if root == None:
            return []
        if not root.left and not root.right:
            return [root.val]
        res = []

        q = [root]

        while len(q) > 0:
            # rightElem = None
            temp = []
            for i in range(len(q)):
                node = q.pop(0)
                temp.append(node.val)

                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            # print(temp)
            l = temp.pop()
            res.append(l)

        return res

