# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        if root is None:
            return []
        
        result = []
        
        def dfs(root, level):
            #if elements in result array and depth are same, we add that root's value to result array.
            if level == len(result):
                result.append(root.val)
                
            #recursively solve this for root.left and root.right.
            for child in [root.right, root.left]:
                
                if child:
                    dfs(child, level + 1)
                
        dfs(root, 0)
        return result