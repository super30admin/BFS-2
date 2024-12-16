# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([root])
        leftparent = None
        rightparent = None

        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()

                if node.left:
                    q.append(node.left)
                    if node.left.val == x:
                        leftparent = node
                    if node.left.val == y:
                        rightparent = node

                if node.right:
                    q.append(node.right)
                    if node.right.val == x:
                        leftparent = node
                    if node.right.val == y:
                        rightparent = node

            if leftparent and rightparent:
                return leftparent != rightparent

            if leftparent or rightparent:
                return False

        return False
