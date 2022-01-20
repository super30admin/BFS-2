# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:

        # store (parent, depth) tuple
        result = []

        # dfs
        def dfs(node, parent, depth):

            if not node:
                return

            # if we find x or y record the parent and level info.
            if node.val == x or node.val == y:
                result.append((parent, depth))

            # traverse left and right subtrees.
            dfs(node.left, node, depth + 1)
            dfs(node.right, node, depth + 1)

        dfs(root, None, 0)

        # unpack two nodes found
        node_x, node_y = result

        # compare and decide whether two nodes are cousins
        return node_x[0] != node_y[0] and node_x[1] == node_y[1]
