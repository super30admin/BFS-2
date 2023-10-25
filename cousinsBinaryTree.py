# search for x and y using depth first search
# 


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        tracker = {}

        def dfs(node,parent,depth,x,y):
            if not node :
                return
            
            dfs(node.left,node,depth+1,x,y)
            dfs(node.right,node,depth+1,x,y)

            if node.val in (x,y):
                tracker[node.val] = (parent,depth)
            
        dfs(root,None,0,x,y)

        cousins = tracker.get(y) and tracker.get(x) and tracker[x][1] == tracker[y][1] and tracker[x][0] != tracker [y][0]

        return cousins