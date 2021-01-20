#time= O(n)
#space= O(h)
#leetcode=yes 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result=[]
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result=[]
        if(root==None):
            return []
        self.helper(root,0)
        return self.result
    def helper(self,root,level):
        if(root==None):
            return
        if(level==len(self.result)):
            self.result.append(root.val)
        self.helper(root.right,level+1)
        self.helper(root.left,level+1)
        