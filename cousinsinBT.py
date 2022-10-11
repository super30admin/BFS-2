# TC = O(n)
# SC - O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # BFS approach
        if root is None or x == y: return False

        q = []
        q.append(root)

        while len(q) > 0:
            x_found = False
            y_found = False
            size = len(q)

            for i in range(size):
                curr = q.pop(0)
                if curr.val == x:
                    x_found = True

                if curr.val == y:
                    y_found = True

                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False

                if curr.left is not None:
                    q.append(curr.left)

                if curr.right is not None:
                    q.append(curr.right)

            if x_found == True and y_found == True: return True
            if x_found == True or y_found == True: return False

        return False