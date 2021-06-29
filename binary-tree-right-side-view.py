# BFS
# Time Complexity: O(n)
# Space Complexity: O(n)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        # Check base condition
        if root is None:
            return []
        
        # Declare a queue and append the root
        # Declare a list to return the right most values
        q = deque()
        finalList = []
        q.append(root)
        
        
        while q:
            # Maintain size var as we want the rightmost element at each level
            size = len(q)
            
            # loop through the length of the queue
            # pop the left most element, check if it is the last
            # If yes, append in the list
            # Append the children in the queue
            for i in range(size):
                curr = q.popleft()
                if i == size - 1:
                    finalList.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
                    
        return finalList


# DFS (right traversal)
class Solution:
    # To declare the result globally
    def __init__(self):
        self.result = []
    
    # DFS function is called recursively on right
    def dfs(self, root, level):
        if root is None:
            return self.result 

        if len(self.result) <= level:
            self.result.append(root.val)
        
        # Perform DFS on right first and then left
        # Do left becoz there might be no children on the right on that level
        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)

    def rightSideView(self, root: TreeNode) -> List[int]:
        # Check base condition
        if root is None:
            return self.result
        
        self.dfs(root, 0)
        return self.result



#DFS with left traversal and replacement
# DFS    
class Solution:
    # To declare the result globally
    def __init__(self):
        self.result = []
    
    # DFS function is called recursively on the children
    def dfs(self, root, level):
        if root is None:
            return self.result 

        # If level is same, append the root value to the result array
        # Else, change the value of the element in the result at that level
        if len(self.result) == level:
            self.result.append(root.val)
        else:
            self.result[level] = root.val
        
        # Perform DFS on left child and right child
        # Do left becoz there might be no children on the right on that level
        self.dfs(root.left, level + 1)
        self.dfs(root.right, level + 1)

    def rightSideView(self, root: TreeNode) -> List[int]:
        # Check base condition
        if root is None:
            return self.result
        
        self.dfs(root, 0)
        return self.result