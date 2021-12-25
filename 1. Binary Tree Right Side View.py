# Approach - With minor modifications from level order traversal code. We have to print the last element in each level
import collections
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    # Time Complexity = O(n)
    # Space Complexity = O(n/2) = O(n)

    def rightSideView(self, root):
        res = []
        q = collections.deque()
        if root:
            q.append(root)

        while len(q):
            qLen = len(q)
            for _ in range(qLen):
                x = q.popleft()

                if x.left:
                    q.append(x.left)
                if x.right:
                    q.append(x.right)
            res.append(x.val)

        return res