
from typing import List, Optional
from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BFSSolution:
# Time Complexity : O(n), where n is the number of nodes in the binary tree
# Space Complexity : O(w), where w is the maximum width of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

    # BFS Approach
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = deque() # Init queue for level order traversal
        result = [] # init result list

        if root is None: # Handling edge case
            return result
        # Adding the root element to queue
        q.append(root)

        # Iterating level by level
        while len(q):
            size = len(q) # Getting the size for traversing the partciular level
            for i in range(size): # Iterating the level
                curr = q.popleft() # Popping the left most element
                if i == size-1: # if last element, then store it in the list
                    result.append(curr.val)
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)

        return result
    
class DFSSolution:
# Time Complexity : O(n), where n is the number of nodes in the binary tree
# Space Complexity : O(H), where H is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

    # DFS
    def __init__(self):
        self.result = []# intializing the result list in global scope because in dfs, result will be added here

    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root: Optional[TreeNode], depth: int)-> None:
        # Doing a In order traversal Root-->Left-->Right
        # So at each depth, we will overwrite the previous element at same depth

        # Checking null/base case
        if root is None:
            return
        
        # Checking if depth is equal to result list size, if so then add the curr element because this is first time we are reaching this depth
        if depth == len(self.result):
            self.result.append(root.val)
        else: # Otherwise just overwrite the value
            self.result[depth] = root.val

        # Moving left
        self.dfs(root.left, depth+1)
        #Moving Right
        self.dfs(root.right, depth+1)