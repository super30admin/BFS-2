from collections import deque
###
# Approach:
# - Use BFS (level-order traversal) with a queue that stores (node, parent).
# - At each level, look for x and y.
# - If both are found at the same level and have different parents → return True (they are cousins).
# - If only one is found at a level → return False (can't be cousins).
# - If neither is found, continue to next level.
#
# Time Complexity: O(n), where n = number of nodes in the tree
# Space Complexity: O(n), for queue storage in the worst case
###
class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isCousins(self, root, x, y):
        if not root:
            return False
        queue = deque()
        queue.append((root, None))
        while queue:
            x_parent, y_parent = None, None
            for i in range(len(queue)):
                curr, parent = queue.popleft()
                if curr.val == x:
                    x_parent = parent
                if curr.val == y:
                    y_parent = parent
                if curr.left:
                    queue.append((curr.left, curr))
                if curr.right:
                    queue.append((curr.right, curr))
            if x_parent and y_parent:
                return x_parent != y_parent
            if x_parent or y_parent:
                return False
        return False
    
    def main(self):
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left.left = TreeNode(4)
        root.right.right = TreeNode(5)

        x = 4
        y = 5

        print("Are cousins:", self.isCousins(root, x, y))

sol = Solution()
sol.main()