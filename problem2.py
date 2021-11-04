#Time complexity O(n), space O(1)
class Solution:
      
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
  #calling dfs for both values      
        xp,xd = self.dfs(root,None,0,x)
        yp,yd=self.dfs(root,None,0,y)
   #If they are from same parent return false, else if there are from differnt parent and are at same depth return true     
        if xp==yp:
            return False
        
        elif xd==yd:
            return True
        
#Dfs calculating parent,depth for left and then right    
    def dfs(self,root,p,d,node):
        
        if root is None:
            return (-1,-1)
        
        if root.val == node:
            return (p,d)
        
        l=self.dfs(root.left,root,d+1,node)
        
        if l[0]!=-1:
            return l
        
        r=self.dfs(root.right,root,d+1,node)
        
        return r
      
