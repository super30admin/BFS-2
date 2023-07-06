# Time Complexity : O(n)
# Space Complexity : O(h) for recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here we ensure that rightmost elements are processed first in each level using reverse preorder traversal.
# Preoder traversal ensure we always process the higher elements before the lower elements.
# The reversed traversal ensures that in each level we visit the elements in a right to left order.

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        res = []
        
        def helper(root, depth):
            if not root:
                return
            if len(res) == depth:
                res.append(root.val)
            helper(root.right, depth+1)
            helper(root.left, depth+1)
            

        helper(root, 0)
        return res