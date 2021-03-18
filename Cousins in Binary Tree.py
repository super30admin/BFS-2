'''
Time Complexity: O(n)
Space Complexity: O(n)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        px,py,xh,yh,c,q = 0,0,0,0,0, [root]
        while q:
            t = []
            c += 1
            for i in q:
                if i:
                    if i.right:
                        t.append(i.right)
                        if i.right.val == x:
                            px = i.val
                            xh = c
                        if i.right.val == y:
                            py = i.val
                            yh = c
                    if i.left:
                        t.append(i.left)
                        if i.left.val == x:
                            px = i.val
                            xh = c
                        if i.left.val == y:
                            py = i.val
                            yh = c
            q = t[:]
        if px != py and xh==yh:
            return True
        return False