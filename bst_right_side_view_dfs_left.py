# Time Complexity : O(N) where N is number of nodes in the tree
# Space Complexity : O(h) where h is height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.traverse(root, 0)
        
        return self.result
        
    def traverse(self, root, level):
        if root is None: return
        
        if len(self.result) == level:
            self.result.append(root.val)
        else:
            self.result[level] = root.val
            
        self.traverse(root.left, level + 1)
            
        self.traverse(root.right, level + 1)