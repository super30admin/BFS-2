#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    xlevel = 0
    ylevel = 0
    xparent = None
    yparent = None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        self.dfs(root,x,y,0,None)
     
        if self.xparent == self.yparent or self.xlevel != self.ylevel:
            return False
        
        return True
        
    def dfs(self,root,x,y,level,parent):
        
        if root == None:
            return
        
        self.dfs(root.left,x,y,level+1,root)
        
        if root.val == x:
            self.xlevel = level
            self.xparent = parent
            
        if root.val == y:
            self.ylevel = level
            self.yparent = parent 
            
        self.dfs(root.right,x,y,level+1,root)
            
        