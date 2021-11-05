# leetcode 199: Binary Tree Right side view
# Method - DFS
# Time - O(n)
# Space - O(n)

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        result = []
        
        def dfs(root, level):
            
            if root is None:
                return 
            
            if level == len(result):
                result.append(root.val)
                
            dfs(root.right, level + 1)
            dfs(root.left, level + 1)
        dfs(root, 0)
        
        return result
        