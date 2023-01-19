# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        stack=[root]
        k1,k2,k3,k4=0,0,0,0
        if not root:
            return 
        while stack:
            lvl=[]
            for i in stack:
                if i.left and i.right:
                    if (i.left.val==x or i.left.val==y)and  (i.right.val==x or i.right.val==y):  
                        return False
                if i.left:
                    lvl.append(i.left)
                    if i.left.val==x or i.left.val==y:
                        if k1:
                            k4=i.left.val
                        else:
                            k1=i.left.val
                if i.right:
                    lvl.append(i.right)
                    if i.right.val==x or i.right.val==y:
                        if k2:
                            k3=i.right.val
                        else:
                            k2=i.right.val

                     
            print(k1,k2,k3,k4)
            if  (k1 and k2) or (k3 and k2) or (k1 and k4) :
                return True 
            k1=k2=0
            stack=lvl
        return False
