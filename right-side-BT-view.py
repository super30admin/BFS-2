"""
Runtime Complexity:
O(n) - where n is the number of nodes. We traverse all the nodes in the tree.
Space Complexity:
O(h) - stack space is the depth of the tree.
Yes, the code worked on leetcode
Issues while coding - No
"""
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        result = []
        self.dfs(root,0,result)
        return result
    
    def dfs(self,root,level,result):
        if not root:
            return
        if level == len(result):
            result.append(root.val)
        self.dfs(root.right,level+1,result)
        self.dfs(root.left,level+1,result)