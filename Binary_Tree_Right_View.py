# Approach:
# Perform a level-order traversal (BFS) to visit nodes level by level. 
# At each level, add the last node (rightmost node) to the result list.
# This ensures only nodes visible from the right side are captured.

# Time Complexity: O(n) - We visit each node exactly once.
# Space Complexity: O(n) - The space required for the queue can grow to O(n) in the worst case.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None

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
        
        # Result list to store right side view nodes
        result = []
        # Queue for level-order traversal
        queue = deque([root])
        
        while queue:
            level_size = len(queue)
            for i in range(level_size):
                node = queue.popleft()
                
                # Add the last node in the current level to the result
                if i == level_size - 1:
                    result.append(node.val)
                
                # Add left and right children to the queue
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        
        return result
