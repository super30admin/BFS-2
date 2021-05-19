"""Cousins in Binary Tree
Time Complexity - O(N)
Space Complexity - O(1) 
APproach -BFS . check the children before adding to the queue"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        queue = collections.deque()
        queue.append(root)
        while queue:
            sizeq = len(queue)
            xfound = False
            yfound = False
            for i in range(sizeq):
                cur = queue.popleft()
                if cur.val == x:
                    xfound =True
                if cur.val == y:
                    yfound =True
                if cur.left and cur.right:
                    if cur.left.val ==x and cur.right.val==y:
                        return False
                    if cur.right.val ==x and cur.left.val==y:
                        return False
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            if xfound and yfound :
                return True
            if xfound or yfound :
                return False
        return False
                    
                    