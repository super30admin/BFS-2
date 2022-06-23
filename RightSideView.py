#TC:O(n)
#SC:O(n)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res=[]
        
        def dfs(root,l):
            if root==None: return 
            if l==len(res):
                res.append(root.val)
            else:
                res[l]=root.val
            dfs(root.left,l+1)
            dfs(root.right,l+1)
            return res
        dfs(root,0)
        return res

'''
#using bfs
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        q = []
        result = []
        if root is None:
            return result
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
            result.append(temp[-1])
        return result

'''