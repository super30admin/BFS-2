# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english: This code computes the right side view of a binary tree using DFS. It keeps track of the current depth (level) and updates the result so that the rightmost node at each level overwrites any previously seen node. By traversing left first and then right, the right child’s value replaces the left one at the same level, leaving only the visible rightmost nodes in the result.

class Solution:
    #TC: O(n)  SC: O(h)
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root is None:
            return result
        self.dfs(result, root, 0)
        return result
    
    def dfs(self, result, root, level):
        if root is None:
            return
        if len(result) == level:
            result.append(root.val)
        else:
            result[level] = root.val

        self.dfs(result, root.left, level + 1)  
        self.dfs(result, root.right, level + 1)  