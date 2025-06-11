"""
Time - O(n)
Space - O(n)
Runs on leetcode - YES
"""
from collections import deque

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            xFound = False
            yFound = False

            for _ in range(size):
                curr = q.popleft()

                if curr.val == x:
                    xFound = True
                if curr.val == y:
                    yFound = True

                if curr.left and curr.right:
                    # check if they are siblings
                    if (curr.left.val == x and curr.right.val == y) or \
                       (curr.left.val == y and curr.right.val == x):
                        return False

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

            # both found at same level, and not siblings
            if xFound and yFound:
                return True
            # one found but not the other — not cousins
            if xFound or yFound:
                return False

        return False