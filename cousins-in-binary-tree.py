import collections
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC : O(N)
# SC : O(N)

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = collections.deque([root,])

        while q:
            size = len(q)
            x_found, y_found = False, False
            for i in range(size):
                curr = q.popleft()
                print(curr.left, curr.right)
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left and curr.right:
                    if (curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x):
                        return False                       
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                
            if x_found and y_found: return True
            if x_found or y_found: return False
        return False