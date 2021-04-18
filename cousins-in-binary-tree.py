# Time Complexity : O(n), where n is the number of nodes
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = list()
        q.append(root)

        while q:
            size = len(q)

            x_found = False
            y_found = False

            for i in range(size):
                node = q.pop(0)

                if node.left and node.right and (
                        (node.left.val == x and node.right.val == y) or (node.left.val == y and node.right.val == x)):
                    return False

                if node.val == x:
                    x_found = True

                if node.val == y:
                    y_found = True

                if x_found and y_found:
                    return True

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)
