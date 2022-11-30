# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        
        ## DFS Solution - left node first
        ## T.C = O(n)
        ## S.C = O(h)
        
        if not root:
            return []
        
        res = []
        def dfs(root, lvl):
            if not root:
                return
            
            if lvl == len(res):
                res.append(root.val)
            else:
                res[lvl] = root.val
            
            dfs(root.left, lvl+1)
            dfs(root.right, lvl+1)
            
        
        dfs(root, 0)
        return res
        
        ################################################
        
        ## DFS Solution - right node first
        ## T.C = O(n)
        ## S.C = O(h)
        
        if not root:
            return []
        
        res = []
        def dfs(root, lvl):
            if not root:
                return
            
            if lvl == len(res):
                res.append(root.val)
            
            dfs(root.right, lvl+1)
            dfs(root.left, lvl+1)
        
        dfs(root, 0)
        return res
        
        ################################################
        ## BFS Solution
        ## T.C = O(n)
        ## S.C = O(n)
        
        if not root:
            return []
        q = [root]
        res = []
        
        while q:
            
            q_len = len(q)
            for i in range(q_len):
                root = q.pop(0)
                
                if i == q_len - 1:
                    res.append(root.val)
                    
                if  root.left:
                    q.append(root.left)
                
                if  root.right:
                    q.append(root.right)
        
        return res
    
        