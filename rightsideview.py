"""
//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""

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
        
        #using dfs
        if root == None:
            return []
        result = []
        self.dfs(root,0,result)
        return result
    def dfs(self,root,level,result):
        if root == None:
            return
        if level == len(result):
            result.append(root.val)
        result[level] = root.val
        self.dfs(root.left,level+1,result)
        self.dfs(root.right,level+1,result)
        
#         T.C = O(n) S.c = O(n)
#         from collections import deque
#         if root is None:
#             return None
#         q=deque()
#         q.append(root)
        
#         result = []
#         while len(q)>0:
#             size = len(q)
#             for i in range(0,size):
#                 node = q.popleft()
#                 if i == size -1:
#                     result.append(node.val)
#                 if node.left!=None:
#                     q.append(node.left)
#                 if node.right!=None:
#                     q.append(node.right)
#         return result
        