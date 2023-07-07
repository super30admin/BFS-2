# Time Complexity : O(n)
# Space Complexity : O(n)
# The code ran on LeetCode
# Level order traversal from right to left, appending elements to result array whenever a new level is reached.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:return []
        queue = deque()
        queue.append((root, 1))
        res = []

        while queue:
            size = len(queue)
            for _ in range(len(queue)):
                cur, level = queue.popleft()
                if len(res) < level:
                    res.append(cur.val)
                if cur.right:
                    queue.append((cur.right, level+1))
                if cur.left:
                    queue.append((cur.left, level+1))
        return res
