# Time Complexity: O(n), where n is number of nodes in the tree
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:
"""
1. Consider BFS approach and a queue to store nodes at each level.
2. Iterate through every level and if x and y are found in the same level but have different parents, return true.
3. Else return false if x and y have same parent or if they are not found in the same level.
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def is_cousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False

        # BFS
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            x_found = y_found = False
            for i in range(size):
                curr = q.popleft()

                # Mark if x or y is found
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True

                # If x and y have same parent, return false
                if curr.left and curr.right:
                    if (curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x):
                        return False

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

            # If x and y are found in same level but have different parents, return true
            if x_found and y_found:
                return True

            # If x and y are not found in same level, return false
            if x_found or y_found:
                return False

        return False

