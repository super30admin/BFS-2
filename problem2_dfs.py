"""
Time Complexity : O(n) where n is the total number of nodes in the tree
Space Complexity : O(h) where h is the height of the tree. In a worst case scenario, at a particular time, recursive stack can have maximum elements equal to the height of the tree.

Did this code successfully run on Leetcode : Yes

Your code here along with comments explaining your approach:
Perfrom the dfs. Push currNode, x, y, root and depth in a recursive stack for every node.
When the particular node is popped then check if its value is equal to x or y and store its parent and depth.
Once all the calls are over check if x_parent != y_parent and x_depth == y_depth.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.x_parent = -1
        self.y_parent = -1
        self.x_level = -1
        self.y_level = -1
        
    def dfs(self,curr, x, y, parent, depth):
        #base
        if curr == None:
            return
        
        #Logic
        if curr.val == x and parent != None:
            self.x_parent = parent.val
            self.x_level = depth
        if curr.val == y and parent != None:
            self.y_parent = parent.val
            self.y_level = depth
            
        self.dfs(curr.left, x,y, curr, depth+1)
        self.dfs(curr.right,x,y,curr, depth+1)
        
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None:
            return False
        self.dfs(root, x, y, None, 0)

        if self.x_parent != self.y_parent and self.x_level == self.y_level:
            return True
        return False
        