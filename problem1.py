'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
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

        def helper(node, level):
            
            if not node: return
            if len(result) == level:
                result.append(node.val)
            else:
                result[level] = node.val
            level += 1
            helper(node.left, level)
            helper(node.right, level)
        
        helper(root, 0)
        return result
        