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

'''
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
        q = []
        result = []
        if root is None:
            return False
        q.append(root)
        while q:
            size=len(q)
            temp=[]
            for i in range(0,size):
                curr=q.pop(0)
                temp.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                if curr.left and curr.right:  
                    
                    if curr.left.val==x and curr.right.val==y: return False
                    if curr.left.val==y and curr.right.val==x: return False
            if x in temp and y in temp: return True
        return False
'''