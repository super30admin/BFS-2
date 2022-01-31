# Time Complexity - O(n)
# Space Complecity - O(n)

from collections import deque
class Solution:
    # right side DFS
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.dfs(root,0,result)
        return result
    
    def dfs(self,root,level,result):
        if root==None:
            return
        if level==len(result):
            result.append(root.val)
        self.dfs(root.right,level+1,result)
        self.dfs(root.left,level+1,result)
    
        
    '''left side DFS
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        self.dfs(root,0,result)
        return result
    
    def dfs(self,root,level,result):
        if root==None:
            return
        if level==len(result):
            result.append(root.val)
        else:
            result[level] = root.val
        
        self.dfs(root.left,level+1,result)
        self.dfs(root.right,level+1,result)'''
        
    '''BFS
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root==None:
            return 
        q = deque()
        q.append(root)
        result = []
        while len(q)!=0:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i==size-1:
                    result.append(curr.val)
                if curr.left!=None:
                    q.append(curr.left)
                if curr.right!=None:
                    q.append(curr.right)
        return result'''
