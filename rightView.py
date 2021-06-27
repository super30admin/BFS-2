# Time Complexity : O(N) 
# Space Complexity :    O(W) (max no.of leaves)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

#bfs

class Solution:
    def __init__(self):
        self.res =[]
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root == None:
            return None
        if root == []:
            return []
        
        q = deque()
        q.append(root)
        
        while(len(q)!=0):
            cursize = len(q)
            
            for i in range(cursize):
                node = q.popleft()
                if node.left!=None:
                    q.append(node.left)
                if node.right!=None:
                    q.append(node.right)
                
                if i==cursize-1:
                    self.res.append(node.val)
        return self.res

# Time Complexity : O(N) 
# Space Complexity :    O(H)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

#dfs
class Solution:
    def __init__(self):
        self.res =[]
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root==None:
            return None
        
        self.dfs(root,0)
        return self.res
    
    def dfs(self,root,level):
        if root==None:
            return 
        
        if len(self.res)==level:
            self.res.append(root.val)
        
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)

        

        