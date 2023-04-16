# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC : O(N)
# SC : O(N)
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        def helper(root, level):
            #base
            if not root:
                return
            #level
            if len(self.res) == level:
                self.res.append(root.val)
            # self.res[level].append(root.val)
            helper(root.right, level+1)
            helper(root.left, level+1)

        self.res = []
        helper(root, 0)
        return self.res