"""
// Time Complexity :O(n) Visiting each node ones.
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NA

//Explanation:
#dfs
use variables xdepth,ydepth to check if the nodes are at the same level.
use variables xparent,yparent to check if the parents of these two nodes is NOT SAME.

#bfs
// Time Complexity :O(n) Visiting each node ones.
// Space Complexity :O(n) all nodes in queue
size variable is required as both x and y values must be at the same level to be cousin.
if root.left == x and root.right == y OR if root.left == y and root.right == x
-> Don't add root in queue.return False.(Values x and y belong to same parent)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def __init__(self):
        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = None
        self.y_parent = None

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root is None: return False

        self.dfs(root,x,y,None,0)
        return self.x_depth == self.y_depth and self.x_parent != self.y_parent

    def dfs(self,root,x,y,parent,depth):
        #base
        if root is None: return
        #logic
        if root.val == x:           # check if value == x
            self.x_depth = depth
            self.x_parent = parent

        if root.val == y:           # check if value == y
            self.y_depth = depth
            self.y_parent = parent

        self.dfs(root.left,x,y,root,depth + 1)  #root -> root.left therefore parent = root
        self.dfs(root.right,x,y,root,depth + 1) #root -> root.right therefore parent = root

"""
# bfs solution
def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
      if root is None: return False

      queue = deque()
      queue.append(root)

      while queue:
          size = len(queue)
          x_found = False
          y_found = False
          for i in range(size):
              current = queue.popleft()
              if current.val == x:x_found = True
              if current.val == y:y_found = True
              if current.left is not None and current.right is not None:
                  if current.left.val ==x and current.right.val ==y : return False
                  if current.left.val ==y and current.right.val ==x: return False
              if current.left is not None: queue.append(current.left)
              if current.right is not None: queue.append(current.right)
          if x_found and y_found: return True
"""
