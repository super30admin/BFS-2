# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""
DFS approach: conditional recursion , if depth of both nodes is same and parent diff, return true
Time complexity: O(n) -> each node will be visited
Space complexity: O(h) -> under the hood recursive stack holding h element at worst 
"""
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x_depth=0
        self.y_depth=0
        self.x_parent=None
        self.y_parent=None
        self.dfs(root,None,0,x,y)
        return (self.x_depth==self.y_depth) and (self.x_parent!=self.y_parent) #compare level of both nodes, they should be same and see their parent, they should be different.


    def dfs(self,root,parent,depth,x,y):
        #base case
        if root==None:
            return
        #logic
        if (x==root.val): #if x value/root found
            self.x_depth=depth #set its depth
            self.x_parent=parent #set its parent


        if (root.val==y): #if y value/root found
            self.y_depth=depth #set its depth
            self.y_parent=parent #set its parent


        self.dfs(root.left, root, depth+1, x, y)
        self.dfs(root.right, root, depth+1, x, y)