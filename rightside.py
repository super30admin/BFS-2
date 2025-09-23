# Time Complexity : O(N) where N is the number of nodes in the binary tree
# Space Complexity : O(h) where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using DFS to traverse the tree. I am keeping track of the level of each node and adding the first node I encounter 
# at each level to the answer list. I am traversing the right subtree first so that the rightmost node at each level is 
# added to the answer list.

from typing import Optional, List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        if not root:
            return []
        def dfs(root,level):
            if not root:
                return 
            if len(ans) == level:
                ans.append(root.val)
            dfs(root.right,level+1)
            dfs(root.left,level+1)
        dfs(root,0)
        return ans
        