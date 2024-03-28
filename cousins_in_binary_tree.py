#BFS
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from collections import deque, TreeNode, Optional, List
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append(root)

        while q:
            size = len(q)
            x_found = False
            y_found = False

            for i in range(size):
                curr = q.popleft()

                if(curr.val == x):
                    x_found = True
                if(curr.val == y):
                    y_found = True
                
                if(curr.left and curr.right):
                    if(curr.left.val == x and curr.right.val == y): return False
                    if(curr.left.val == y and curr.right.val == x): return False
                
                if curr.left:
                    q.append(curr.left)
                
                if curr.right:
                    q.append(curr.right)
                
            if(x_found and y_found): return True
        
        return False
    
#DFS
# Time Complexity : O(n)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    x_depth, y_depth = 0, 0
    x_parent, y_parent = None, None

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.dfs(root, 0, None, x, y)

        return self.x_depth == self.y_depth and self.x_parent != self.y_parent

    def dfs(self, root, depth, parent, x, y):
        if not root:
            return 

        if root.val == x:
            self.x_depth = depth
            self.x_parent = parent

        if root.val == y:
            self.y_depth = depth
            self.y_parent = parent

        self.dfs(root.left, depth + 1, root, x, y)
        self.dfs(root.right, depth + 1, root, x, y)