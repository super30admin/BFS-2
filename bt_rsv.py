###
# Approach:
# - We perform a level-order traversal (BFS) using a queue.
# - At each level, we collect all node values.
# - After finishing a level, we take the **last element** in that level's list
#   (because that's what is visible from the right side).
# - Finally, we return a list of all these rightmost elements from each level.
#
# Time Complexity: O(n), where n is the number of nodes (each visited once)
# Space Complexity: O(n), for queue and level-wise result storage
###
from collections import deque

class TreeNode:
    def __init__(self, val=0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def rightSideView(self, root):
        if not root:
            return []
        queue = deque()
        res = []
        queue.append(root)
        level = 0
        while queue:
            res.append([])
            for i in range(len(queue)):
                curr = queue.popleft()
                res[level].append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            level += 1
        result = []
        for r in res:
            result.append(r[-1])
        return result
    
    def main(self):
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left.right = TreeNode(5)
        root.right.right = TreeNode(4)

        result = self.rightSideView(root)
        print("Right Side View:", result)

sol = Solution()
sol.main()