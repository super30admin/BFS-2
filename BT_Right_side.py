# Time Complexity:O(n) (where n = number of nodes)
# Space Complexity:O(h) (where h = height of the tree)
# Did this code successfully run on LeetCode?:Yes
# Problems faced while coding this:None
# Approach: DFS approach
# here the right side view is acheived by recursing on left side.

class Solution:
    
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.result = []
        if root == None:
            return self.result
        self.dfs(root, 0)
        return self.result

    def dfs(self, root, lvl):
        if root == None:
            return 
        if lvl == len(self.result):
            self.result.append(root.val)
        else:
            self.result[lvl] = root.val

        self.dfs(root.left, lvl + 1)
        self.dfs(root.right, lvl + 1)
