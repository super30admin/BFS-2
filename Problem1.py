"""
Implemented using the technique discussed in today's session, where I used BFS (level-order traversal) to capture the rightmost node at each level of the binary tree.
Time Complexity: O(n)
Space Compelxity: O(n) (Worst Case)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        queue = deque([root])
        result = []
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if i == size - 1:
                    result.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
        return result     