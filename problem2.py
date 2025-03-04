'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = collections.deque()
        q.append(root)

        while q:
            l = len(q)
            xFound, yFound = False, False
            for i in range(l):
                node = q.popleft()
                if node.val == x:
                    xFound = True
                if node.val == y:
                    yFound = True
                if node.left and node.right:
                    if (node.left.val == y and node.right.val == x) or (node.left.val == x and node.right.val == y):
                        return False
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)

            if xFound and yFound:
                return True
            if xFound or yFound:
                return False
        return False