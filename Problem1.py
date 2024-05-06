## Problem 1

#Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

# Approach
# Perform recurssive DFS on the tree. Call dfs with arguments as root and level(0). 
# base condition is if root== None: return. This will return when we reach the leaf node. Check if level == len(res). This would mean that no element has been added from that level to the result
# if yes, append the root value. Since we want the right side view, call root.right first then root.left. This will give us the first element from right at each level


# Time Complexity: O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self,root,level):
        if root == None:
            return 
        
        if level == len(self.res):
            self.res.append(root.val)
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.res = []
        self.dfs(root,0)
        return self.res