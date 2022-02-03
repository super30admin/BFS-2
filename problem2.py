#TIme Complexity =O(n)
#Space Complexity = O(h)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if(root==None):
            return None
        queue  = [root]
        
        while(len(queue)!=0):
            l = len(queue)
            flagA = False
            flagB= False
            while(l!=0):
                val = queue.pop(0)
                if(val.right!=None and val.left!=None and ((val.right.val==x and val.left.val==y) or (val.left.val==x and val.right.val==y))):
                    return False
                if(val.val == x):
                    flagA=True
                if(val.val==y):
                    flagB=True
                if(flagA and flagB):
                    return True
                if(val.right!=None):
                    queue.append(val.right)
                if(val.left!=None):
                    queue.append(val.left)
                l-=1
                
            if(flagA or flagB):
                    return False
        return False