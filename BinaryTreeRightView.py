#Time Complexity: O(N)
#Space Complexity: O(h)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.result = []
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        self.dfs(root,0)  
        return self.result
    def dfs(self,root,lvl):
        if root is None:
            return
        if len(self.result)==lvl:
            self.result.append(root.val)
        self.dfs(root.right,lvl+1)
        self.dfs(root.left,lvl+1)