# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False

        # x_found, y_found = False, False
        q = collections.deque()
        q.append(root)

        while q:
            size = len(q)
            x_found, y_found = False, False

            for _ in range(size):
                curr = q.popleft()
                if curr.val == x:
                    x_found = True 
                elif curr.val == y:
                    y_found = True
                if (curr.left and curr.right):
                    if (curr.left.val == x and curr.right.val == y) or (curr.right.val == x and curr.left.val == y):
                        return False
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)

            if x_found and y_found:
                return True
        return False

