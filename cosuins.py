#TC-O(n)
#SC-O(n)
#logic-in bfs,check if the children of same node are x,y,if yes return false,else check if both are found in same level,if yes return true
#else return false
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        li = []
        xfound=False
        yfound=False
        li=[root]
        while li:
            l = len(li)
            for i in range(l):
                r = li.pop(0)
                if r.left and r.right and r.left.val==x and r.right.val==y or r.left and r.right and r.left.val==y and r.right.val==x:
                    print('here')
                    return False
                if r.left and r.left.val==x or r.right and r.right.val==x:
                    xfound=True
                if r.left and r.left.val==y or r.right and r.right.val==y:
                    yfound=True
                if r.left:
                    li.append(r.left)
                if r.right:
                    li.append(r.right)
            if xfound and yfound:
                return True
            if xfound and not yfound or yfound and not xfound:
                return False
        return False