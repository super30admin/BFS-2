// Time Complexity : O(V+E)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        def recurrdfs(root,x,y,parent,depth): #performs dfs until x and y is found
            if root is None :
                return 
            if root.val==x: # find x
                self.depthX=depth
                self.parentX=parent
            elif root.val==y:# find y
                self.depthY=depth
                self.parentY=parent
            
            recurrdfs(root.left,x,y,root,depth+1) 
            recurrdfs(root.right,x,y,root,depth+1)
            
        self.depthX=-1
        self.depthY=-1
        self.parentX=TreeNode(-1)
        self.parentY=TreeNode(-1)
        #both depthX, depthY and parentX, parentY is defined as global.
        if root is None:
            return False
        recurrdfs(root,x,y,None,0)
        return self.depthX==self.depthY and self.parentX!=self.parentY #if found, return true else return false
 