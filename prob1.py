# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# do dfs in the order Right - Root - Left
# and when the len of result array is the same as level, 
# that means we don't have the right most element ,
# so at that point add the current root's value


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    
    result = []
    
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        global result
        result = [] 
        if root is None:
            return result 
        self.dfs(root, 0)
        return result

    def dfs(self, root, level):

        global result

        if root is None:
            return 
        
        if len(result) == level:
            result.append(root.val)
        
        
        self.dfs(root.right, level + 1)

        
        self.dfs(root.left, level + 1)  