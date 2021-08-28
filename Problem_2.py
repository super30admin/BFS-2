# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.xlevel = -1
        self.ylevel = -1
        self.xparent = None
        self.yparent = None

    """
    DFS Approach
    if x and ydifferent level and different parents -> true
    TC - O(n)
    SC - O(h)
    """

    def approach1(self, root, x, y, level, parent):
        if not root:
            return
        if self.xparent and self.yparent:
            return
        if root.val == x:
            self.xlevel = level
            self.xparent = parent
        elif root.val == y:
            self.ylevel = level
            self.yparent = parent
        self.approach1(root.left, x, y, level + 1, root)
        self.approach1(root.right, x, y, level + 1, root)

    """
    BFS
    TC - O(n)
    SC - O(n)
    """

    def approach2(self, root, x, y):
        q = []
        q.append(root)
        while len(q) > 0:
            size = len(q)
            xf, yf = False, False
            for i in range(size):
                cur = q.pop(0)
                if cur.val == x:
                    xf = True
                if cur.val == y:
                    yf = True
                if cur.left != None and cur.right != None:
                    if cur.left.val == x and cur.right.val == y:
                        return False
                    if cur.left.val == y and cur.right.val == x:
                        return False
                if cur.left != None:
                    q.append(cur.left)
                if cur.right != None:
                    q.append(cur.right)
            if xf and yf:
                return True
            if xf or yf:
                return False
        return False

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        # self.approach2(root,x,y,0,None)
        # return self.xlevel == self.ylevel and self.xparent != self.yparent
        return self.approach2(root, x, y)