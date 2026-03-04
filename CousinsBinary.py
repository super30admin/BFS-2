from typing import Optional, List
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BFSSolution:
# Time Complexity : O(n), where n is the number of nodes in the binary tree
# Space Complexity : O(2w), where w is the maximum width of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

    # BFS approach
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque() # to store nodes while traversing level order
        parent_q = deque() # to store parent of each node 
        x_found = False
        y_found = False
        x_parent = None
        y_parent = None

        # add root to queue
        if root is not None:
            q.append(root)
        # add root's parent to parentQ
        parent_q.append(None)

        while len(q):
            # Iterate at the particular level
            size = len(q)
            for _ in range(size):
                curr = q.popleft() # get current element 
                parent = parent_q.popleft() # Get current element's parent 

                # check if curr is equal to x or y
                if curr.val == x:
                    x_found = True
                    x_parent = parent
                    continue
                elif curr.val == y:
                    y_found = True
                    y_parent = parent
                    continue

                if curr.left is not None: # Append left child
                    q.append(curr.left)
                    parent_q.append(curr)
                
                if curr.right is not None: # appending right child
                    q.append(curr.right)
                    parent_q.append(curr)
                 
            if x_found and y_found and (x_parent != y_parent): # CHecking at each level if x and y found and their parent not same
                return True
            if x_found or y_found: # If either x or y is found, but not both then fail
                return False

        return False
    
class BFSSolution2:
# Time Complexity : O(n), where n is the number of nodes in the binary tree
# Space Complexity : O(w), where w is the maximum width of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

    # BFS approach
    from collections import deque
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque() # to store nodes while traversing level order
        x_found = False
        y_found = False

        # add root to queue
        if root is not None:
            q.append(root)

        while len(q):
            # Iterate at the particular level
            size = len(q)
            for _ in range(size):
                curr = q.popleft() # get current element 

                # check if curr is equal to x or y
                if curr.val == x:
                    x_found = True
                    continue
                elif curr.val == y:
                    y_found = True
                    continue   

                if curr.left is not None: # Append left child
                    q.append(curr.left)
                
                if curr.right is not None: # appending right child
                    q.append(curr.right)
                
                if curr.left is not None and curr.right is not None: # Eliminating the scenario where x and y are siblings, so they can't be cousins
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.left.val == y and curr.right.val == x:
                        return False
                 
            if x_found and y_found: # CHecking at each level if x and y found and their parent not same
                return True
            if x_found or y_found: # If either x or y is found, but not both then fail
                return False

        return False
    
class DFSSolution:
# Time Complexity : O(n), where n is the number of nodes in the binary tree
# Space Complexity : O(H), where H is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

    # DFS Approach
    def __init__(self):
         # Initializing variables in global scope which are required in DFS for finding cousins
        self.x_found = False
        self.y_found = False
        self.x_depth = -1
        self.y_depth = -1
        self.x_parent = None
        self.y_parent = None

    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.dfs(root, 0, None,x , y) # Starting recursion

        return self.x_found and self.y_found and (self.x_parent != self.y_parent) and (self.x_depth == self.y_depth)

    def dfs(self, root: Optional[TreeNode], depth: int, parent: Optional[TreeNode], x: int, y: int)-> None:
        # Bae case
        if root is None:
            return
        if self.x_found and self.y_found: # If found, then return instead of continuing with dfs
            return

        # check if root.val is equal to x or y
        if root.val == x:
            self.x_found = True
            self.x_depth = depth
            self.x_parent = parent
        elif root.val == y:
            self.y_found = True
            self.y_depth = depth
            self.y_parent = parent
        
        # Move Left
        self.dfs(root.left, depth+1, root,x,y)
        # Move Right
        self.dfs(root.right, depth+1, root,x,y)