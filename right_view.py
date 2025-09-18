def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
    self.result=[]
    if root is None:
        return self.result
    
    self.helper(root,0)
    return self.result

def helper(self,root,level):
    if root is None:
        return
    size=len(self.result)
    if size==level:
        self.result.append(root.val)

    self.helper(root.right,level+1)
    self.helper(root.left,level+1)