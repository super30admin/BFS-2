# Time Complexity : O(N) for while loop
# Space Complexity : O(N) for queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# do optimized bfs, 
# so before we push children into the queue, we check 
# if the children are not x and not y


from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:

    def isCousins(self, root, x, y):

        if root is None:
            return False
        q = deque()
        x_found, y_found = False, False
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left is not None and curr.right is not None:
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right) 
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
        
        return False


        