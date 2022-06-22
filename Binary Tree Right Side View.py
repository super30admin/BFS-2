""""// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# DFS -RightSide View (From left side)
class Solution:
    def __init__(self):
        self.result = []

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return
        self.helper(root, 0)
        return self.result

    def helper(self, root, level):
        if not root:
            return
        if len(self.result) == level:
            self.result.append(root.val)
        else:
            self.result[level] = root.val
        self.helper(root.left, level + 1)
        self.helper(root.right, level + 1)

# DFS -RightSide View(From right side)
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return
#         self.helper(root,0)
#         return self.result
#     def helper(self,root, level):
#         if not root:
#             return
#         if len(self.result)==level:
#             self.result.append(root.val)
#         self.helper(root.right, level+1)
#         self.helper(root.left, level+1)

""""// Time Complexity : O(n)
// Space Complexity : O(n/2) ~ O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# BFS- RightSide View
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        q=[root]
        result=[]
        if not root:
            return result

        while q:
            size=len(q)
            for i in range(size):
                curr=q.pop(0)
                if i==size-1:
                    result.append(curr.val)
                if curr.left!=None:
                    q.append(curr.left)
                if curr.right!=None:
                    q.append(curr.right)
        return result





# DFS -LeftSide View (From right side)
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return
#         self.helper(root,0)
#         return self.result
#     def helper(self,root, level):
#         if not root:
#             return
#         if len(self.result)==level:
#             self.result.append(root.val)
#         else:
#             self.result[level]=root.val
#         self.helper(root.right, level+1)
#         self.helper(root.left, level+1)

# DFS -LeftSide View (From left side)
# class Solution:
#     def __init__(self):
#         self.result=[]
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         if not root:
#             return
#         self.helper(root,0)
#         return self.result
#     def helper(self,root, level):
#         if not root:
#             return
#         if len(self.result)==level:
#             self.result.append(root.val)
#         self.helper(root.left, level+1)
#         self.helper(root.right, level+1)

# BFS- LeftSide View
# class Solution:
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

#         q=[root]
#         result=[]
#         if not root:
#             return result

#         while q:
#             size=len(q)
#             for i in range(size):
#                 curr=q.pop(0)
#                 if i==0:
#                     result.append(curr.val)
#                 if curr.left!=None:
#                     q.append(curr.left)
#                 if curr.right!=None:
#                     q.append(curr.right)
#         return result

