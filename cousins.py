def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
    self.x_level=-1
    self.y_levell=-1
    self.x_parent=None
    self.y_parent=None

    def helper(root,level,parent):
        if root is None:
            return
        if root.val==x:
            self.x_level=level
            self.x_parent=parent
        
        if root.val==y:
            self.y_level=level
            self.y_parent=parent
        
        helper(root.left,level+1,root)
        helper(root.right,level+1,root)
    helper(root,0,None)
    return self.x_level==self.y_level and self.x_parent!=self.y_parent

    