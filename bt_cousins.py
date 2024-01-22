""" Explanation: At every node, we traverse recursively to check whether both the nodes belong to the same parent or not. Also, we keep
    track of whether the node is found or not, and what depth we're at inorder to check for cousin/sibling connection.
    Time Complexcity: O(n)
    Space Complexcity: O(h)
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root: [TreeNode], x: int, y: int) -> bool:
        
        if not root:
            return False

        parent_x, depth_x, found_x = None, None, False
        parent_y, depth_y, found_y = None, None, False

        def dfs(node, parent, depth):
            nonlocal parent_x, depth_x, found_x, parent_y, depth_y, found_y

            if not node:
                return

            if node.val == x:
                parent_x, depth_x, found_x = parent, depth, True
            elif node.val == y:
                parent_y, depth_y, found_y = parent, depth, True

            if found_x and found_y:
                return

            dfs(node.left, node, depth + 1)
            dfs(node.right, node, depth + 1)

        dfs(root, None, 0)

        return found_x and found_y and depth_x == depth_y and parent_x != parent_y