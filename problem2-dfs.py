# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.xDepth = 0
        self.yDepth = 0
        self.xParent = None
        self.yParent = None
        
        self.dfs(root, None, 0, x , y)
        return self.xDepth == self.yDepth and self.xParent != self.yParent
    
    def dfs(self, root, parent, depth, x, y):
        #base
        if root == None: return 
        #logic
        if root.val == x:
            self.xDepth = depth
            self.xParent = parent
        if root.val == y:
            self.yDepth = depth 
            self.yParent = parent
        
        self.dfs(root.left, root, depth+1, x, y)
        self.dfs(root.right, root, depth+1, x, y)
            
#Time complexity O(n)
#Space complexity O(h)
#Using DFS to record child and parent value and comparing if the child values are at same level and parents are different or not.
        