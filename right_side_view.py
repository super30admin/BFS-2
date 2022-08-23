# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#BFS
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return  
        q = deque()
        q.append(root)
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if (i == size - 1):
                    res.append(curr.val)
                    
                if curr.left is not None:
                    q.append(curr.left)
                
                if curr.right is not None:
                    q.append(curr.right)
        return res
      
      
 #DFS  from right side
# Time Complexity : O(n)
# Space Complexity : O(h)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.res = []
        
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return  
        q = deque()
        q.append(root)
        
        
        self.dfs(root, 0, self.res)
        return self.res
        
    def dfs(self, root, depth, res):
        #base
        if not root:
            return 
        #logic
        if depth == len(self.res):
            res.append(root.val)
            
        self.dfs(root.right, depth + 1, res)
        self.dfs(root.left, depth + 1, res)
        return self.res
      
      
      
      
#DFS  from left side
# Time Complexity : O(n)
# Space Complexity : O(h)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
      
      
      class Solution:
    def __init__(self):
        self.res = []
        
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return  
        q = deque()
        q.append(root)
        
        
        self.dfs(root, 0, self.res)
        return self.res
        
    def dfs(self, root, depth, res):
        #base
        if not root:
            return 
        #logic
        if depth == len(self.res):
            res.append(root.val)
        else:
            res[depth] = root.val
        
        self.dfs(root.left, depth + 1, res)
        self.dfs(root.right, depth + 1, res)
        
        return self.res
        
        
