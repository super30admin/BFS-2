#Time Complexity : O(n)
#Space Complexity : O(h)
#Did your code run on leetcode : yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#APPROACH : traversing tree from left side using DFS
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        
        if root == None: return result
        
        self.dfs(root, 0, result)
        
        return result
    
    def dfs(self, root: Optional[TreeNode] , level : int, result:List[int])->None:
        if root == None: return
        
        if len(result) == level:
            result.append(root.val)
        else:
            result[level] = root.val
        
        self.dfs(root.left,level + 1, result)
        #stack.pop()
        self.dfs(root.right,level + 1,result)
