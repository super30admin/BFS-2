# Time Complexity : O(N) 
# Space Complexity :    O(W)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


#bfs

class Solution:
    def __init__(self):
        self.x_found = False
        self.y_found = False
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root==None:
            return False
        q = deque()
        q.append(root)
        
        while(len(q)!=0):
            cursize = len(q)
            for i in range(cursize):
                node = q.popleft()
                if node.val==x:
                    self.x_found = True
                if node.val==y:
                    self.y_found = True
                #check if same parent
                if node.left!=None and node.right!=None:
                    if node.left.val==x and node.right.val==y:
                        return False
                    if node.left.val==y and node.right.val==x:
                        return False
                
                if node.left!=None:
                    q.append(node.left)
                if node.right!=None:
                    q.append(node.right)
            if self.x_found and self.y_found:
                return True

            if self.x_found or self.y_found:
                return False
        return False
                
                
#dfs 
                
class Solution:
    def __init__(self):
        self.x_parent =None
        self.y_parent = None
        self.x_depth = 0
        self.y_depth = 0
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root==None:
            return False
        self.dfs(root,None,0,x,y)
        if self.x_depth==self.y_depth and self.x_parent!=self.y_parent:
            return True
        
    def dfs(self,root,parent,level,x,y):
        if root==None:
            return
        
        if root.val==x:
            self.x_parent = parent
            self.x_depth = level
        
        if root.val==y:
            self.y_parent = parent
            self.y_depth = level
        
        self.dfs(root.left,root,level+1,x,y)
        self.dfs(root.right,root,level+1,x,y)
            
        
        
        