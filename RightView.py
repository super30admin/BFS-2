# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Do level order traversal using a queue.
# For each level, we add the last node's value to the result which gives the right side view of the tree.
# For each level, if we add the first node's value to the resul, then it will give the left side view of the tree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []

        if root is None:
            return res

        q = deque()
        q.append(root)

        while q:
            size = len(q)

            for i in range(size):
                curr = q.popleft()

                if i == size - 1:
                    res.append(curr.val)

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return res
        