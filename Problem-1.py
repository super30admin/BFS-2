# Time Complexity :O(N)
# Space Complexity :O(H)..H= height of the tree 
# Did this code successfully run on Leetcode :yes 
# Any problem you faced while coding this :no 

# Your code here along with comments explaining your approach
# We do a modified pre-order DFS (root -> right -> left) to ensure we visit the rightmost nodes first at each level.  
# When visiting a new level for the first time, we append that node’s value to the result.
# This gives the right-side view of the binary tree.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        self.helper(root, result,0)
        return result
    def helper(self, root,result,level):
        #base
        if not root:
            return

        #logic
        if len(result) == level:
            result.append(root.val)

        #recursion
        self.helper(root.right,result,level+1)
        self.helper(root.left,result,level+1)
        
        