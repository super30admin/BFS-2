# Time complexity: O(n)
# Space complexity: O(n) for using the queue data structure
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition is to do a BFS(level order traversal) and store the element if it's the right most

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                if i == (size - 1):
                    result.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return result
