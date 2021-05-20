from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    #BFS
    def rightSideView_B(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        result = []
        q  = deque()
        q.append(root)
        
        while q:
            size = len(q)
            print(q[0].val) #Peek 
            result.append(q[0].val)
            
            for i in range(size):
                node = q.popleft()
                
                if node.right:
                    q.append(node.right)
                if node.left:
                    q.append(node.left)
            
        return result
    
    #DFS    
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        
        self.result = []
        self.dfs(root,0)
        return self.result
    
    
    def dfs(self,root,lvl):
        
        #base
        if not root:
            return
        
        #logic
        if lvl == len(self.result):
            self.result.append(root.val)
        
        self.dfs(root.right,lvl+1)
        self.dfs(root.left,lvl+1)
        
        
