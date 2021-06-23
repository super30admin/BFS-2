# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# BFS Approach
import queue
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = []
        if root == None:
            return result
        q = queue.Queue()
        q.put(root)
        while not q.empty():
            size = q.qsize()
            for i in range(0,size):
                curr = q.get()    
                if i == size-1:
                    result.append(curr.val)
                if curr.left != None:
                    q.put(curr.left)
                if curr.right != None:
                    q.put(curr.right)        
        return result
# Time Complexity: O(n)
# Space Complexity: O(n)   

# DFS Approach
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result = []
        if root == None:
            return self.result
        self.dfs(root, 0)      
        return self.result
    
    def dfs(self, root: TreeNode, level: int) -> None:
        if root == None:
            return
        if len(self.result) == level:
            self.result.append(root.val)
        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)

# Time Complexity: O(n)
# Space Complexity: O(h)
  