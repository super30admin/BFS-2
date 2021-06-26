# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result = []
        if not root: return self.result
        self.dfs(root, 0)
        return self.result
        
        
    def dfs(self, root, level):
        if root == None: return 
        size = len(self.result)
        if level == size:
            self.result.append(root.val)
        self.dfs(root.right, level+1)
        self.dfs(root.left, level+1)
        
    
        

#Time complexity is O(n) and space complexity is O(h)
#Using DFS on right side and pushing the right child of each node to result
        