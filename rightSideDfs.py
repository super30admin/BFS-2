# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    #DFS
    # TC O(n) Sc O(h)
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = [] # to store integer
        if root is None:
            return result
        def dfs(root, lvl):
            
            # base
            if root is None:
                return
            
            # logic
            if lvl == len(result):
                result.append(root.val)         
            dfs(root.right, lvl + 1)
            dfs(root.left, lvl + 1)    
        dfs(root, 0)
        return result
        
