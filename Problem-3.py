#Approach
# every time store the parent of x and y and calculate the depth and if xdepth and y depth and parents are different return true else false


#Complexities
#Time: O(N)
#Space: O(N)


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_depth, x_parent = None, None
        y_depth, y_parent = None, None

        depth = 0
        queue = []
        queue.append((root, None))

        while queue:
            size = len(queue)
            for _ in range(size):
                node, parent = queue.pop(0)

                if x_depth != None and y_depth != None:
                    break

                if node.val == x:
                    x_depth, x_parent = depth, parent
                if node.val == y:
                    y_depth, y_parent = depth, parent

                if node.left:
                    queue.append((node.left, node))
                if node.right:
                    queue.append((node.right, node))
            depth += 1

        return x_depth == y_depth and x_parent != y_parent and x_parent != None