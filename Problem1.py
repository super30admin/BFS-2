'''
Problem: Binary Tree Right Side View
Time Complexity: O(n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        visit every node in DFS manner
        take result array as global variable
        if level exist then replace value else append value
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        def level(root, d):
            if root is None:
                return
            
            if len(result)==d:
                result.append(root.val)
            else:
                result[d] = root.val

            
            if root.left:
                level(root.left, d+1)
            if root.right:
                level(root.right, d+1)
        
        level(root, 0)
        return result
               