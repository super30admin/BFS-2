"""
BFS Approach --
TC - O(n)
SC - O(n)
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root is None: return []

        xFound = False
        yFound = False

        q = deque()
        q.append(root)

        while q:
            qsize = len(q)
            for i in range(qsize):
                curr = q.popleft()
                if curr.val == x:
                    xFound = True
                if curr.val == y:
                    yFound = True

                # check if parent is same
                # we check if the curr nodes left and right child are equal to
                # x and y respectively. Which means both children share same parent
                # so they are not cousins
                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    # x and y values might be reversed but still same parents
                    if curr.left.val == y and curr.right.val == x:
                        return False

                # append left and right child nodes to q
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)

            # check if x and y are on the same level
            if xFound == True and yFound == True:
                return True
            # if one of them is found
            if xFound == True or yFound == True:
                return False
        return False