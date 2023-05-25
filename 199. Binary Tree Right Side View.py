#Time Complexity:O(n)
#Space Complexity:O(h-height of the tree)

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
        if root==None:
            return None
        result=[]
        def dfs(root,level):
            if root==None:
                return
            if level==len(result): 
                result.append(root.val)
            dfs(root.right,level+1)
            dfs(root.left,level+1)
        dfs(root,0)
        return result