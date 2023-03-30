
# DFS
# Time Complexity - O(n)
# Space Complexity- O(H)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.depthx, self.parentx = None, None
        self.depthy, self.parenty = None, None
        
        self.dfs(root, None, 0, x, y)
        return (self.depthx == self.depthy) and (self.parentx != self.parenty)

    def dfs(self, root, parent, depth, x, y):
        if not root:
            return
        
        if root.val == x:
            self.depthx = depth
            self.parentx = parent
            
        if root.val == y:
            self.depthy = depth
            self.parenty = parent

        if self.parentx == None or self.parenty == None: 
            self.dfs(root.left, root, depth+1, x, y)
        if self.parentx == None or self.parenty == None: 
            self.dfs(root.right, root, depth+1, x, y)




# BFS 
# Time Complexity - O(n)
# Space Complexity- O(n)


class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_found = False 
        y_found = False 
        q = [root]

        while q : 
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                if curr.left and curr.right: 

                    if curr.left.val == x and curr.right.val == y: 
                        return False
                    if curr.left.val == y and curr.right.val == x: 
                        return False

                if curr.val == x : 
                    x_found = True
                if curr.val == y : 
                    y_found = True

                if curr.left :
                    q.append(curr.left)
                if curr.right :
                    q.append(curr.right)

            if x_found and y_found:
                return True
            if x_found or y_found:
                return False

        return False

        

