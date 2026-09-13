# Time Complexity : O(n)
# Space Complexity : O(h) where h is the height of the tree (O(n) in worst case)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return res

        def helper(root,res,level):
            if not root:
                return 
            if len(res) == level:
                res.append(root.val)
            helper(root.right, res,level + 1)
            helper(root.left, res, level + 1)
        helper(root,res,0)
        return res
