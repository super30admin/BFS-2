# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        q = []
        q.append(root)
        temp1 = None
        temp2 = None
        flag = False
        while len(q) != 0:
            temp = len(q)
            for i in range(temp):
                inter = q.pop(0)
                if inter.left:
                    if inter.left.val == x:
                        temp1 = inter
                        flag = True
                    elif inter.left.val == y:
                        temp2 = inter
                        flag = True
                    q.append(inter.left)
                if inter.right:
                    if inter.right.val == x:
                        temp1 = inter
                        flag = True
                    elif inter.right.val == y:
                        temp2 = inter
                        flag = True
                    q.append(inter.right)
            if flag:
                break
        if temp1 is None or temp2 is None:
            return False
        return temp1 != temp2