#TC:O(n)
#SC:O(1)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        res=[[-1,-1],[-1,-1]]
        
        def helper(root,l,x,y):
            print(root,l,x,y)
            if root.left!=None:
                if(x==root.left.val):
                    
                    res[0]=[root.val,l]
                if(y==root.left.val):
                    res[1]=[root.val,l]
                helper(root.left,l+1,x,y)
            if root.right!=None:
                if(x==root.right.val):
                    res[0]=[root.val,l]
                if(y==root.right.val):
                    res[1]=[root.val,l]
            
                helper(root.right,l+1,x,y)
            
        if root==None: return False    
        helper(root,0,x,y)
        print(res)
        if res[0][0]!=res[1][0] and res[0][1]==res[1][1]:
            return True
        return False