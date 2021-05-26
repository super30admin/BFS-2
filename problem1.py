from queue import Queue

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root == None:
            return None
        self.result = []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,count):
        if root == None:
            return None
        if count == len(self.result):
            self.result.append(root.val)
        else:
            self.result[count] = (root.val)
        # self.result[count].append(root.val)
        self.dfs(root.left,count+1)
        self.dfs(root.right,count+1)
