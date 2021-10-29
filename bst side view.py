# TC = O(n)
# SC = O(n)
# run on LC


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        output = []

        if (root == None):
            return output

        queue = collections.deque([root])

        while queue:
            ls = len(queue)

            for i in range(ls):
                node = queue.popleft()

                if (i == ls - 1):
                    output.append(node.val)

                if (node.left != None):
                    queue.append(node.left)
                if (node.right != None):
                    queue.append(node.right)

        return output
