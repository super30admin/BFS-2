# Time Complexity: O(n) , where n is number of nodes in the tree
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:
"""
1. Consider BFS approach and a queue to store the nodes at each level.
2. Traverse through every node level by level and add its left and right child to the queue.
3. Simultaneously, append the last node of each level to the result.
"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def right_Side_view(self, root: TreeNode) -> List[int]:
        if not root:
            return []

        # BFS approach
        result = []
        q = deque()
        q.append(root)

        while q:
            size = len(q)

            # Traverse through every node and add its left and right child to the queue.
            # Add the last node in every level to the result
            for i in range(size):
                curr = q.popleft()
                if i == size - 1:
                    result.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

        return result

