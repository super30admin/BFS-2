# Time Complexity = O(n)
# Space Complexity = O(n), queue


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> list[int]:
        if root == None:
            return []
        
        result = []
        q = []
        q.append(root)
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if (i == size - 1):
                    result.append(curr.val)
                
                if curr.left != None:
                    q.append(curr.left)
                    
                if curr.right != None:
                    q.append(curr.right)
                    
        return result
        
'''                

# Using DFS
# TC = O(n)
# SC = O(h), recursive stack

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return []
        
        self.result = []
        
        self.dfs(root, 0)
        
        return self.result
    
   # Doing Right subtree first 
    def dfs(self, root, lvl):
        if root == None:
            return
        
        size = len(self.result)
        if lvl == size:
            self.result.append(root.val)
            
        self.dfs(root.right, lvl + 1)
        self.dfs(root.left, lvl + 1)

    
    # Doing left subtree first
    def dfs(self, root, lvl):
        if root == None:
            return
        
        size = len(self.result)
        if lvl == size:
            self.result.append(root.val)
        
        else:
            self.result[lvl] = root.val
            
        self.dfs(root.left, lvl + 1)
        self.dfs(root.right, lvl + 1)
        
    '''