# Time Complexity: O(n) because we are traversing the tree once
# Space Complexity: O(h) because we are using a stack to store the nodes
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We solve this problem using DFS. We will keep track of the parent and level of each node 
and then when we find the value we are looking for we store them. And then finally compare 
for a final boolean. This can also be directly solved using BFS.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None: return False

        self.x_info, self.y_info = [x], [y]
        self.dfs(root, 0, -1)

        if self.x_info[1] != self.y_info[1] and self.x_info[2] == self.y_info[2]:
            return True
        else:
            return False

    def dfs(self, node, level, parent_val):
        if node == None: return

        self.dfs(node.left, level + 1, node.val)

        if node.val == self.x_info[0]:
            self.x_info.append(parent_val)
            self.x_info.append(level)
        if node.val == self.y_info[0]:
            self.y_info.append(parent_val)
            self.y_info.append(level)

        self.dfs(node.right, level + 1, node.val)
