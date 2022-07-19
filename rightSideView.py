# Time Complexity : O(v+e) where v is the vertices of the graph and e is the edges
# Space Complexity : O(v+e)
# Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        res = []
        queue = [root]
        while queue:
            size = len(queue)
            # print("Size: ", size)
            for i in range(size):
                node = queue.pop(0)
                if i == size - 1:
                    res.append(node.val)
                    # print("i: ", i, " res: ", res)
                    # print("Q: ", queue)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return res
