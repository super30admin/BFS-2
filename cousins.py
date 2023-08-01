#TC - O(N)
#SC - O(N)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        track = {}
        def dfs(node,parent,depth,x,y):
            if not node:
                return 
            if node.val in (x,y):
                track[node.val] = (parent,depth)
            dfs(node.left,node,depth+1,x,y)
            dfs(node.right,node,depth+1,x,y)
        dfs(root,None,0,x,y)
        return track.get(x) and track.get(y) and track[x][1] == track[y][1] and track[x][0] != track[y][0]

        