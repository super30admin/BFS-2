"""
TC - O(n)
SC - O(h)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return root

        queue = deque([root, ])
        print(queue)
        print("*******************")

        rightside = []

        while queue:
            queuelen = len(queue)

            for i in range(queuelen):
                node = queue.popleft()
                print(node)

                if i == queuelen - 1:
                    rightside.append(node.val)

                # add child nodes
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return rightside
