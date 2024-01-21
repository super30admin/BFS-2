'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach
Using BFS, I traverse the tree level wise and create a list at every level. I append the last element in the list to
another list which I will be returning


'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        q = collections.deque()

        q.append(root)

        while q:
            level = []
            length = len(q)

            for i in range(length):
                node = q.popleft()
                if node:
                    q.append(node.left)
                    q.append(node.right)
                    level.append(node.val)

            if level:
                res.append(level[-1])

        return res
