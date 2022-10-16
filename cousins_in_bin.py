# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: 'Optional[TreeNode]', x: int, y: int) -> bool:

        if root == None or x==y: return False

        q = []
        q.append(root)
        
        xfound = False
        yfound = False

        while q:
            
            size1 = len(q)
            for i in range(size1):
                curr = q.pop(0)

                if curr.val == x:
                    xfound = True
                if curr.val == y:
                    yfound = True

                #check for the case when they are siblings and not cousins meaning they have same parent
                if curr.left and curr.right:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False

                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
            if xfound and yfound: return True
            if xfound or yfound: return False

        return True
        

        