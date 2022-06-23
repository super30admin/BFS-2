# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
# BFS
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if root==None: return result
        from collections import deque
        q=deque()
        q.append(root)
        while len(q)!=0:
            s=len(q)
            for i in range(s):
                cur=q.popleft()
                if i==s-1:
                    result.append(cur.val)
                if cur.left!=None: q.append(cur.left)
                if cur.right!=None: q.append(cur.right)
        return result
    
# #DFS solution
# # Time Complexity: O(n)
# # Space Complexity: O(h)
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         self.result=[]
#         self.dfs(root,0)
#         return self.result
#     def dfs(self, root: Optional[TreeNode],level:int):
        # if root==None: return
        # if level==len(self.result):
        #     self.result.append(0)
        # self.result[level]=root.val
        # self.dfs(root.left,level+1)
        # self.dfs(root.right,level+1)
        
        
        
        
        
        # if root==None: return
        # if level==len(self.result):
        #     self.result.append(root.val)
        # self.dfs(root.right,level+1)
        # self.dfs(root.left,level+1)
        
        
        