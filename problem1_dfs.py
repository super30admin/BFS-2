"""
Time Complexity : O(n) where n is the total number of nodes in the tree
Space Complexity : O(h) where h is the height of the tree. In a worst case scenario, at a particular time, recursive stack can have maximum elements equal to the height of the tree.

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
First perfrom the right call to the parent and append the element to the resultant arrayList if len(arrayList) == depth.
As we are doing the right call first length of the arrayList and depth will be equal when we traverse through righMost elements,

This can be done by doing left call and right call i.e. ususal dfs by overwriting the already depth element present in the resultant array.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    
    def dfs(self, root, depth):
        #base
        if root == None:
            return
        
        #Logic
        if depth == len(self.result):
            self.result.append(root.val)
        # else: //In case left call is made first
        #     self.result[depth] = root.val
        # self.dfs(root.left, depth + 1) 
        self.dfs(root.right, depth+1)
        self.dfs(root.left, depth + 1)
        
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        self.dfs(root,0)
        return self.result
        