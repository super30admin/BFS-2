## Problem 1

#Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res=[]
        seen = set()
        self.helper(root,res,0,seen)
        return res
    
    def helper(self,root,res,level,seen):
        if root is None:
            return
        if level not in seen:
            seen.add(level)
            res.append(root.val)
        self.helper(root.right,res,level+1,seen)
        self.helper(root.left,res,level+1,seen)
        #Approach: Recursion
        