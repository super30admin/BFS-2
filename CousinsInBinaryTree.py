# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach: DFS

# Condition: Same level and different parents
# Depnding on the above conditions, at every node we visit we need to check if the node is equal to one of cousin. Store its level and parent. Same goes for another cousin if found. Then after the complete dfs recurssion check for conditions using the values stored.

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root == None:
            return True
        
        self.dfs(root, None, 0, x,y)
        return self.x_lvl == self.y_lvl and self.x_parent != self.y_parent
    
    def dfs(self, root, parent, lvl, x,y):
        if root == None:
            return
        
        if root.val == x:
            self.x_lvl = lvl
            self.x_parent = parent
            
        if root.val == y:
            self.y_lvl = lvl
            self.y_parent = parent
            
        self.dfs(root.left, root, lvl + 1, x,y)
        self.dfs(root.right, root, lvl + 1, x,y)