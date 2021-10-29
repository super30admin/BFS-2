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
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if (root == None):
            return False

        queue = collections.deque([(root, 0)])

        while (queue):
            ls = len(queue)
            px = py = -1

            for i in range(ls):
                node, parent = queue.popleft()

                if (node.val == x):
                    px = parent
                elif (node.val == y):
                    py = parent

                if (node.left != None):
                    queue.append((node.left, node.val))
                if (node.right != None):
                    queue.append((node.right, node.val))

            if (px != -1 and py != -1 and px != py):
                return True

        return False
