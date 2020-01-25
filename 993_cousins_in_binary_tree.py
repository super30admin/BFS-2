# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque


class Solution:
    def isCousinsBFS(self, root: TreeNode, x: int, y: int) -> bool:
        """
            https://leetcode.com/problems/cousins-in-binary-tree/
            // Time Complexity : O(n)
                'n' is the number of nodes
            // Space Complexity : O(n)
            // Did this code successfully run on Leetcode : Yes
            // Any problem you faced while coding this : No
            // Three line explanation of solution in plain english :
                    - BFS, maintain level using size variable
                    - If the current parent nodes' children are equal to x and y
                            they are siblings, return False
                    - If current levels' x_found and y_found are true,
                            we found cousions, return True
        """
        if not root:
            return False

        queue = deque()
        queue.append(root)

        while queue:
            x_found = y_found = False
            # level
            for i in range(len(queue)):
                cur = queue.popleft()
                # if the current parent nodes children are equal to x and y
                # then they are siblings
                if cur.left and cur.right:
                    # Nodes having same parent, checked at one level up
                    if (cur.left.val == x and cur.right.val == y) or (cur.left.val == y and cur.right.val == x):
                        return False
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)

                if cur.val == x:
                    x_found = True
                if cur.val == y:
                    y_found = True
            # if both child are found at same level,
            # they are cousions
            if x_found and y_found:
                return True

        return False

    x_parent = y_parent = None
    x_depth = y_depth = -1

    def isCousinsDFS(self, root: TreeNode, x: int, y: int) -> bool:
        """
             https://leetcode.com/problems/cousins-in-binary-tree/
             // Time Complexity : O(n)
                 'n' is the number of nodes
             // Space Complexity : O(h)
             // Did this code successfully run on Leetcode : Yes
             // Any problem you faced while coding this : No
             // Three line explanation of solution in plain english :
                     - DFS, initialise x_parent, y_parent, x_depth, y_depth global variables
                     - If the current node is equal to x or y:
                             set the global variables accordingly
                             call dfs recursively on left and right subtrees
                     - For x and y to be siblings, they must have the same depth and different parents.
                       Compare at last
         """
        if not root:
            return False
        self._helper(root, 0, x, y, None)

        return self.x_depth == self.y_depth and self.x_parent != self.y_parent

    def _helper(self, root: TreeNode, depth: int, x: int, y: int, parent: TreeNode) -> None:

        # base
        if root is None: return

        # logic
        if root.val == x:
            self.x_depth = depth
            self.x_parent = root
        if root.val == y:
            self.y_depth = depth
            self.y_parent = root

        self._helper(root.left, depth + 1, x, y, root)
        self._helper(root.right, depth + 1, x, y, root)
