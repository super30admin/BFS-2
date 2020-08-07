class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        x_depth=0
        y_depth=0
        x_parent=None
        y_parent=None
        if root==None:
            return False
        def dfs(root,level,parent,x,y):
            nonlocal x_depth,y_depth,x_parent,y_parent
            if root==None:
                return 
            if x==root.val:
                x_parent=parent
                x_depth=level
            if y==root.val:
                y_parent=parent
                y_depth=level
            dfs(root.left,level+1,root,x,y)
            dfs(root.right,level+1,root,x,y)
        dfs(root,0,None,x,y)
        return x_parent!=y_parent and x_depth == y_depth
#Time-Complexity:O(N)
#Space-Complexity:O(N)