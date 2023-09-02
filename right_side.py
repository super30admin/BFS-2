# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return 
        result = []
        q = []
        q.append(root)

        while q:
            size = len(q)
            li = []
            for i in range(0,size):
                curr = q.pop(0)
                li.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            result.append(li[-1])
        return result

        