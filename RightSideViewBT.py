# Definition for a binary tree node.
from typing import Optional,List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        def dfs(root, level, res):
            #base
            if not root : return res
            #logic using left recursive call 
            if len(res) == level:
                res.append(root.val)
            else:
                res[level] = root.val
            dfs(root.left, level+1, res)
            dfs(root.right, level+1, res)
            
        dfs(root,0,res)
        return res

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# class Solution:
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         res = []
#         def dfs(root, level, res):
#             #base
#             if not root : return res
#             #logic using right recursive call 
#             if len(res) == level:
#                 res.append(root.val)
#             dfs(root.right, level+1, res)
#             dfs(root.left, level+1, res)
#         dfs(root,0,res)
#         return res

# # Definition for a binary tree node.
# # class TreeNode:
# #     def __init__(self, val=0, left=None, right=None):
# #         self.val = val
# #         self.left = left
# #         self.right = right
# class Solution:
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         res = []
#         def dfs(root, level, res):
#             #base
#             if not root : return res
#             #logic
#             if len(res) == level:
#                 res.append(root.val)
#             dfs(root.right, level+1, res)
#             dfs(root.left, level+1, res)
#         dfs(root,0,res)
#         return res

# # Definition for a binary tree node.
# # class TreeNode:
# #     def __init__(self, val=0, left=None, right=None):
# #         self.val = val
# #         self.left = left
# #         self.right = right
# class Solution:
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         res ,q = [],deque([root])
#         if not root : return res
#         while q:
#             size = len(q)
#             for i in range(size):
#                 node = q.popleft()
#                 if i == size-1:
#                     res.append(node.val)
#                 if node.left:
#                     q.append(node.left)
#                 if node.right:
#                     q.append(node.right)
#         return res

        