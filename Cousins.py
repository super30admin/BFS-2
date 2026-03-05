# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Do a level order traversal using a queue, checking each level for x and y.
# If they are siblings (same parent), return false immediately.
# If both found on the same level but not siblings, return true, otherwise false.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append(root)

        x_found, y_found = False, False

        while q:
            size = len(q)

            for _ in range(size):
                curr = q.popleft()

                if curr.left and curr.right:
                    # siblings - same parent
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.right.val == x and curr.left.val == y:
                        return False

                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

            if x_found and y_found:
                return True # same leval
            if x_found or y_found:
                return False # different level - not cousins

        return True