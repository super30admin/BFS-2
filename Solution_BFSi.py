"""

Time complexity O(N)
Space complexity O(N)

Iterative BFS
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_BFSi:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root is None:
            return False
        dic={}
        q=[]
        q.append((root,0,0))
        while q:
            node,parentVal,level=q.pop(0)
            if node:
                dic[node.val]=[parentVal,level]
                q.append((node.left,node.val,level+1))
                q.append((node.right,node.val,level+1))
        return dic[x][1]==dic[y][1] and  dic[x][0]!=dic[y][0]
        