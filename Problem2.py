# Doing level order traversal and at each level if its not of same parent already now if they both true then return true. If one of them true return false. Else go next level
# TC: O(N)
# SC: O(N)
# Yes, this worked in leetcode


from queue import Queue
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        q = Queue()
        xind = False
        yind = False
        q.put(root)
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                curr = q.get()
                if curr.left and curr.right:  
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                if curr.val == x:
                    xind = True
                if curr.val == y:
                    yind = True

                if curr.left:
                    q.put(curr.left)
                if curr.right:
                    q.put(curr.right)
            if xind and yind:
                return True
            if xind or yind:
                return False
        return False