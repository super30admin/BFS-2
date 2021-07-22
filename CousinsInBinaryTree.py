# Time Complexity : O(n)
# Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            x_found = False
            y_found = False
            for i in range(size):
                curr = q.popleft()
                if curr.val == x: x_found = True
                if curr.val == y: y_found = True
                if curr.left != None and curr.right != None:
                    if curr.left.val == x and curr.right.val == y: return False
                    if curr.right.val == x and curr.left.val == y: return False
                if curr.left != None: q.append(curr.left)
                if curr.right != None: q.append(curr.right)
            if x_found and y_found: return True
            if x_found or y_found: return False
        return False