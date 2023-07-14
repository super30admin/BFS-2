'''
Problem:  Cousins in Binary Tree
Time Complexity: O(n), where n is given nodes
Space Complexity: O(n) for queue
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
       travered each node using BFS
       set flags to true if x and y found
       at then end check whether x and y are cousins by checking depth and parents

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = deque()
        queue.append((root, None))

        while queue:
            size = len(queue)
            xparent= None
            yparent = None
            xfound = False
            yfound = False
            for i in range(size):
                node, parent = queue.popleft()
                if x == node.val:
                    xparent = parent
                    xfound = True
                if y == node.val:
                    yparent = parent
                    yfound = True
                if node.left:
                    queue.append((node.left, node))
                if node.right:
                    queue.append((node.right, node))
            
            if xfound and yfound:
                return xparent != yparent
            
            if xfound or yfound:
                return False
        
        return False