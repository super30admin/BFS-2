# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach 1: Using dfs

# The apporach quite simple and straightforward. Here we will deal in terms of level. On every level we want the most right value in the tree. It can be either the right child in leaf node or a left child in leaf node. Keep traversing right and on each new level add the right node in the result array, if present or else add the left node.

# Time Complexity: O(n)
# Space Complexity: O(h) ; h = height of the tree
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result = []
        
        if root == None:
            return self.result
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root, level):
        if root == None:
            return
        if len(self.result) == level:
            self.result.append(root.val)
            
        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)
        

# Approach 2: Using bfs

# Time Complexity: O(n)
# Space Complexity: O(n/2)
# class Solution:
#     def rightSideView(self, root: TreeNode) -> List[int]:
