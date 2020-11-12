"""
Time complexity O(N)
Space complexity O(N)

"""



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_cousinBFS:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q=[]
        q.append(root)
        while q:
            xfound=False
            yfound=False
            size=len(q)
            for i in range(size):
                curr=q.pop(0)
                if(curr.val==x):
                    xfound=True 
                if(curr.val==y):
                    yfound=True 
                if curr.left and curr.right:
                    if(curr.left.val==x and curr.right.val==y) or (curr.right.val==x and curr.left.val==y):
                        return False
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                if xfound and yfound:
                    return True
        return False
                    
        