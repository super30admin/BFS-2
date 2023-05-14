# BFS-2

## Problem 1
# Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# BFS Solution
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        result = []
        queue = deque()
        queue.append(root)
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


## Problem 2
# Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

# Time Complexity : O(n)
# Space Complexity : O(n) # for queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# BFS Solution
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root: return False
        queue = deque()
        queue.append(root)
        while queue:
            size = len(queue)
            x_found = False
            y_found = False
            for i in range(size):
                curr = queue.popleft()
                if curr.val == x: x_found = True
                if curr.val == y: y_found = True
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y: return False
                    if curr.left.val == y and curr.right.val == x: return False
                if curr.left: queue.append(curr.left)
                if curr.right: queue.append(curr.right)
            if x_found and y_found: return True
            if x_found or y_found: return False
        return False



