# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# TC: O(n)
# SC: O(n)
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None or (x == y):
            return False

        queue = []
        queue.append(root)

        x_found = False
        y_found = False

        while len(queue) != 0:
            q_size = len(queue)
            for i in range(q_size):
                curr = queue.pop(0)
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if x_found == True and y_found == True:
                return True
            if (x_found == True and y_found == False) or (y_found == True and x_found == False):
                return False
        return False

