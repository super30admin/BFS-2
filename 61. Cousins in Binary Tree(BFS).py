# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None:
            return False

        q = [root]
        while q:
            size = len(q)
            x_found, y_found = False, False
            for i in range(size):
                current = q.pop(0)
                if current.val == x:
                    x_found = True
                if current.val == y:
                    y_found = True
                if current.left and current.right:
                    if current.left.val == x and current.right.val == y:  # checking if they are babies of the same parent i fyes we'll return false
                        return False
                    if current.left.val == y and current.right.val == x:
                        return False
                if current.left:
                    q.append(current.left)
                if current.right:
                    q.append(current.right)
            if x_found and y_found:
                print("*" * 100)
                return True
            if x_found or y_found:
                return False

        return False
