# time:0(n)
# space :0(1)
#approach 1: dfs
class Solution(object):
    def dfs(self,root,level):
        if root is None:
            return self.result
        if (len(self.result) -1) < level:
            self.result.append(root.val)
        if root.left is None and root.right is None:
            return self.result
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)
        return self.result
    def rightSideView(self, root):
        self.result = []

        if root is None:
            return self.result
        
        return self.dfs(root,0)
        