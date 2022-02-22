
# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Followed approach from class
#DFS Right First

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        def recur(root, depth):
            nonlocal result
            
            if not root:
                return
            
            if depth == len(result):
                result.append(root.val)           
            
            recur(root.right, depth + 1)
            recur(root.left, depth + 1)

        result = []
        recur(root, 0)
        return result