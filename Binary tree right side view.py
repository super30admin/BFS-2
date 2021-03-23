'''
TC: O(n)
SC: O(n) Height of tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        res = []
        temp = []
        lvl, prevlvl = 0,0
        q = []
        q.append([root,lvl])
        while q:
            node, lvl = q.pop(0)
            if lvl != prevlvl:
                res.append(temp[-1])
                temp = []
            temp.append(node.val)
            prevlvl = lvl
            if node.left:
                q.append([node.left,lvl+1])
            if node.right:
                q.append([node.right, lvl+1])
        res.append(temp[-1])
        return res