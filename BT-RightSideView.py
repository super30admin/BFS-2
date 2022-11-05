#Time Complexity : O(n)
#Space Complexity : O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:

        if root == None:
            return []

        result = []
        q = [root]

        while q:
            size = len(q)
            for i in range(0, size):
                curr = q.pop(0)
                if i == size - 1:
                    result.append(curr.val)
                if curr.left != None:
                    q.append(curr.left)
                if curr.right != None:
                    q.append(curr.right)

        return result