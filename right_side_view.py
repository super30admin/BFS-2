# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
APPROACH:
1. If the tree is empty, return an empty list right away.
2. Use BFS to process the tree one level at a time, using queue size to track level boundaries.
3. Within each level, process nodes left to right, adding children to the queue as usual.
4. The last node processed in each level is the one visible from the right side.
5. Add that last node's value to the result before moving to the next level.

PATTERN:
Tree BFS / Level Order Traversal

TIME COMPLEXITY:
O(n) - every node is visited and processed exactly once

SPACE COMPLEXITY:
O(n) - queue can hold up to one full level of nodes in the worst case

EXAMPLE:
Input:
        1
       / \
      2   3
       \    \
        5    4

Output: [1, 3, 4]
Why: level 0 rightmost is 1, level 1 rightmost is 3, level 2 rightmost is 4
"""

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        if root is None:
            return []  # empty tree has no view to return

        result = []  # stores the rightmost value from each level
        q = collections.deque()  # queue used for BFS
        q.append(root)  # start BFS with the root node

        while q:    
            level_size = len(q)  # number of nodes in current level

            for i in range(level_size):

                current_node = q.popleft()  # process next node in this level
                
                # last node processed in this level is the rightmost one
                if i == level_size - 1:
                    result.append(current_node.val)
                
                # add children to queue so they get processed in next level
                if current_node.left:
                    q.append(current_node.left)

                if current_node.right:
                    q.append(current_node.right)

        return result  # rightmost values collected level by level