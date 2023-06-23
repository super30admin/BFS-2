from collections import defaultdict
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        """
        Using DFS, to find the values of x and y first; keeping track of x and y parent; 
        keeping track of x and y dept
        Time Complexity: O(N)
        Space Complexity : O(H)
        """
        if root is None:  return None
        self.x = x
        self.y = y
        self.x_parent = None
        self.y_parent = None
        self.x_depth, self.y_depth = 0,0
        def dfs_helper(root, parent, depth):
            #base Condition
            if root is None : return 
            
            #logic
            if root.val == self.x:
                self.x_parent = parent
                self.x_depth = depth
                
            if root.val == self.y:
                self.y_parent = parent
                self.y_depth = depth
            if root or root.left:    
                dfs_helper(root.left, root, depth + 1)
            if root or root.right:
                dfs_helper(root.right, root, depth + 1)
        
       
        dfs_helper(root,None, 0)
        
        return self.x_parent != self.y_parent and self.x_depth == self.y_depth
