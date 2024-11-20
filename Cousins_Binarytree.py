# Approach:
# Perform a level-order traversal (BFS) to find the parent and depth of nodes x and y.
# Check if x and y have the same depth but different parents.
# Return True if both conditions are satisfied; otherwise, return False.

# Time Complexity: O(n) - We traverse all nodes in the tree once.
# Space Complexity: O(n) - Space required for the queue in the worst case.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: None


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        
        # Queue for BFS; each element is a tuple (node, parent, depth)
        queue = deque([(root, None, 0)])
        
        x_info = y_info = None  # To store (parent, depth) for x and y
        
        while queue:
            node, parent, depth = queue.popleft()
            
            # Check if the current node matches x or y
            if node.val == x:
                x_info = (parent, depth)
            if node.val == y:
                y_info = (parent, depth)
            
            # If both x and y are found, no need to traverse further
            if x_info and y_info:
                break
            
            # Add children to the queue with updated parent and depth
            if node.left:
                queue.append((node.left, node, depth + 1))
            if node.right:
                queue.append((node.right, node, depth + 1))
        
        # x and y are cousins if they have the same depth but different parents
        if x_info and y_info:
            return x_info[1] == y_info[1] and x_info[0] != y_info[0]
        
        return False
