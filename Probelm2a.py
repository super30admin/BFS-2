# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Time complexity: O(N), where N is the number of nodes in the binary tree.
        Space complexity: O(H), where H is the height of the binary tree.
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        x_depth, y_depth = 0, 0  # Initialize the depth variables for x and y
        x_parent, y_parent = None, None  # Initialize the parent variables for x and y

        def dfs(root, x, y, curr_depth, curr_parent):
            # Declare the variables as global to modify the outer variables
            nonlocal x_depth, y_depth, x_parent, y_parent
            if root is None:
                return
            if root.val == x:
                x_depth = curr_depth
                x_parent = curr_parent
            if root.val == y:
                y_depth = curr_depth
                y_parent = curr_parent
            # Recursively traverse the left subtree
            dfs(root.left, x, y, curr_depth+1, root)
            # Recursively traverse the right subtree
            dfs(root.right, x, y, curr_depth+1, root)

        # Call the DFS function starting from the root node with initial depth 0 and parent None
        dfs(root, x, y, 0, None)

        # Check if x and y are at the same depth and have different parents
        return (x_depth == y_depth) and (x_parent != y_parent)
