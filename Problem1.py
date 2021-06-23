# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#saving the depth and going to right such that only one element of depth is added
class Solution:
    def __init__(self):
        self.a = {}
        self.out = []
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.helper(root,0)
        return self.out
    
    def helper(self,root,ind):
        if root == None:
            return;
        if ind not in self.a:
            self.a[ind] = True
            self.out.append(root.val)
        self.helper(root.right,ind+1)
        self.helper(root.left,ind+1)