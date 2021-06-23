# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    
    """DFS implementation traversing right nodes first and then left ones
    Time complexity-O(n)
    Space complexity-O(h) 
    (in worst case when tree is right skewed then space complexity-O(n))"""
    def __init__(self):
        self.arr=[]
        
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        self.dfs(root, 0)
        return self.arr
    
    def dfs(self, root, level):
        if not root:
            return
        if level==len(self.arr):
            self.arr.append(root.val)
        self.dfs(root.right, level+1)
        self.dfs(root.left, level+1)

"""DFS Implementation traversing left nodes first and then right nodes"""
#     def __init__(self):
#         self.arr=[]
        
#     def rightSideView(self, root: TreeNode) -> List[int]:
#         if not root:
#             return []
#         self.dfs(root, 0)
#         return self.arr
    
#     def dfs(self, root, level):
#         if not root:
#             return
#         if level==len(self.arr):
#             self.arr.append(root.val)
#         self.arr[level]=root.val
#         self.dfs(root.left, level+1)
#         self.dfs(root.right, level+1)
        
        
        # """BFS implementation
        # Time complexity-O(n) as we are going through all nodes
        # Space Complexity-O(n) as we are using queue which would contain n/2 elements
        # if given a complete binary tree in worst case"""
        # q=deque()
        # arr=[]
        # if not root:
        #     return
        # q.append(root)
        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         curr=q.popleft()
        #         if i==size-1:
        #             arr.append(curr.val)
        #         if curr.left:
        #             q.append(curr.left)
        #         if curr.right:
        #             q.append(curr.right)
        # return arr
                
                
            
        
        
        
        