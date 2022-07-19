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
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root or root.val == x or root.val == y:
            return False
        queue = [root]
        xFound = False
        yFound = False
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)

                if node.val == x:
                    xFound = True

                if node.val == y:
                    yFound = True

                if node.left and node.right:
                    val1 = node.left.val
                    val2 = node.right.val

                    if((x == val1 and y == val2) or (x == val2 and y == val1)):
                        return False

                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)

            if xFound and yFound:
                return True
            if xFound or yFound:
                return False
        return False
