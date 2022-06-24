# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.parentX = None
        self.parentY = None
        self.depthX = None
        self.depthY = None
        if not root:
            return False
        self.dfs(root, x, y, 0, None)
        if self.parentX != self.parentY and self.depthX == self.depthY:
            return True
        return False

    # // Time Complexity : O(N)
    # // Space Complexity : O(N)
    def dfs(self, root, x, y, depth, parent):
        # base
        if not root:
            return
        if root.val == x:
            self.parentX = parent
            self.depthX = depth
        if root.val == y:
            self.parentY = parent
            self.depthY = depth

        # logic
        self.dfs(root.left, x, y, depth + 1, root.val)
        self.dfs(root.right, x, y, depth + 1, root.val)

    # // Time Complexity : O(N)
    # // Space Complexity : O(N)
    # Also same from before but optimized and doesn't use space to keep track of parents.
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        flagX = False
        flagY = False

        queue = collections.deque([root])

        while root:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if curr.val == x:
                    flagX = True
                if curr.val == y:
                    flagY = True
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y: return False
                    if curr.left.val == y and curr.right.val == x: return False
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            if flagX and flagY:
                return True
            if flagX or flagY:
                return False
        return False