# Time Complexity :
# O(N)

# Space Complexity :
# O(h) (height of the Tree) 

# Did this code successfully run on Leetcode :
#Yes

#We go through the tree in a DFS manner. We check if the left/right element of the current node is one of the required elements, then we add the current node as the parent and current depth as the depth of that required value found
#At the end of DFS we check if they are at the same level and if their parents are different, then we return True, False otherwise

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if root == None :
            return 
        self.x_parent = -1
        self.x_depth = -1
        self.y_parent = -1
        self.y_depth = -1
        self.dfs(root,0,x,y)

        if self.x_depth == self.y_depth: 
            if self.y_parent != self.x_parent :
                return True
        return False

    def dfs (self,root,depth,x,y):
        if root == None :
            return 

        if root.left != None :
            if root.left.val == x :
                self.x_parent = root.val
                self.x_depth = depth
            elif root.left.val == y :
                self.y_parent = root.val
                self.y_depth = depth

        if root.right != None :
            if root.right.val == x :
                self.x_parent = root.val
                self.x_depth = depth
            elif root.right.val == y :
                self.y_parent = root.val
                self.y_depth = depth
            
        self.dfs(root.left,depth+1,x,y)
        self.dfs(root.right,depth+1,x,y)

