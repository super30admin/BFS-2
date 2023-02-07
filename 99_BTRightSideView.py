# Time complexity: O(n)
# Space Complexity: BFS(O(n)), DFS(O(h))
from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right



class Solution:
    # bfs solution
    def rightSideView(self, root):
        result = []
        queue = deque([root])
        if root is None:
            return result
        while queue:
            size = len(queue)
            for i in range(size):
                    element = queue.popleft()
                    if i == size - 1:
                        result.append(element.val)
                    if element.left:
                         queue.append(element.left)
                    if element.right:
                         queue.append(element.right)
        return result      


    # dfs solution
    def rightSideView1(self, root):
        self.result = []
        self.dfs(root,0)
        return self.result
        
        
    def dfs(self,root,level):
        if root == None:
            return

        if len(self.result) == level:
            self.result.append(root.val)
        else:
            self.result[level] = root.val
        
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)