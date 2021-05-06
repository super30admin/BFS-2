## Problem 2

#Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

# Definition for a binary tree node.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        treeValDict={}
        tree=[(root,None,0)]
        while tree:
            node,parent,depth=tree.pop(0)
            if node.left:
                tree.append((node.left,node,depth+1))
            if node.right:
                tree.append((node.right,node,depth+1))
            treeValDict[node.val]=(parent,depth)
        r1,r2=treeValDict[x],treeValDict[y]
        return r1[0]!=r2[0] and r1[1]==r2[1]