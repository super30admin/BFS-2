# Time Complexity : O(n)
# Space Complexity : O(n) with internal stack space
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I do an preorder traversal where I process root, root.right and root.left. I maintain level
# and at each recursive level if it's the first node at that level then add it to the result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        results = []
        self.current_max = -1
        def helper(root, level):
            if not root:
                return
            
            if level > self.current_max:
                results.append(root.val)
                self.current_max = level
                
            helper(root.right, level+1)
            helper(root.left, level+1)
        
        helper(root, 0)
        return results
            