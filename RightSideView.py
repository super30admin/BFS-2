class Solution:
    def rightSideView(self, root):
        self.res = []
        if not root:
            return []
        
        self.dfs(root, 0)
        return self.res
    
    def dfs(self, root, level):
        if not root:
            return
        if level == len(self.res):
            self.res.append(root.val)
        
        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)
        
if __name__ == "__main__":
    s = Solution()
    root = [1,2,3,None,5,None,4]
    print(s.rightSideView(root))