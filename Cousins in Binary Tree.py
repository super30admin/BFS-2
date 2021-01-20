# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque

class Solution:
    #Solution 1
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        #Approach: BFS
        #Time Complexity: O(n)
        #Space Complexity: O(n) // deque
        
        de = deque()
        de.append(root)
        
        while de:
            sz = len(de)    #for level-order traversal
            temp = set()
            for i in range(sz):
                popped = de.popleft()
                temp.add(popped.val)
                
                if popped.left and popped.right:
                    if popped.left.val in [x,y] and popped.right.val in[x,y]: #siblings
                        return False
                
                if popped.left:
                    de.append(popped.left)
                if popped.right:
                    de.append(popped.right)
            
            if x in temp and y in temp: #cousins
                return True
            if x in temp or y in temp: #neither siblings nor cousins
                return False
    
    #Solution 2
    """
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        #Approach: DFS
        #Time Complexity: O(n)
        #Space Complexity: O(h) // under the hood
           
        self.parentX, self.parentY = None, None
        self.levelX, self.levelY = None, None
        
        self.dfs(root, None, 0, x, y)
        
        return self.parentX != self.parentY and self.levelX == self.levelY
        
    def dfs(self, root, parent, level, x, y):
        #base
        if not root:
            return
        
        #logic
        if root.val == x:
            self.parentX = parent
            self.levelX = level
            
        if root.val == y:
            self.parentY = parent
            self.levelY = level
            
        self.dfs(root.left, root, level + 1, x, y)
        #st.pop()
        self.dfs(root.right, root, level + 1, x, y)
    """