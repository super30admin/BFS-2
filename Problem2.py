# time:0(n)
# space :0(1) //res contains only 2 elements 

class Solution(object):
    def dfs_util(self,root,x,y,level,prev):
        if root is None:
            return 
        if root.val == x:
            self.res.append([root.val,level,prev])
        if root.val == y:
            self.res.append([root.val,level,prev])
        prev = root.val
        self.dfs_util(root.left,x,y,level+1,prev)
        self.dfs_util(root.right,x,y,level+1,prev)
    
    def isCousins(self, root, x, y):
        
        if root is None:
            return False
        
        self.res = []
        
        self.dfs_util(root,x,y,0,0)
        
        print(self.res)
        
        lev1 = self.res[0][1]
        par1 = self.res[0][2]
        
        lev2 = self.res[1][1]
        par2 = self.res[1][2]
        
        if lev1 != lev2:
            return False
        
        if par1 == par2:
            return False
        
        return True
        