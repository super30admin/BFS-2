# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        result = {}
        def helper(root, parentRoot, depth, x, y):
            if not root:return
            
            helper(root.left, root, depth + 1, x, y)
            helper(root.right, root, depth + 1, x, y)
            
            if root.val in (x,y):
                result[root.val] = (parentRoot, depth)
                
        helper(root, None, 0, x, y)
        finalAns = result.get(x) and result.get(y) and result[x][1] == result[y][1] and result[x][0] != result[y][0]
            
            
        return finalAns
    
# T.C => O(N)
# S.C => O(H)
# Approach => Helper is a dfs function. Here we are keeping track of the parent and the depth level of the x and y element. 
# If the depth is equal but both the nodes must not contain the same parent node. then we can saw they are cousins. Just keep the track of node and depth level of x and y in a dictionary and validate it on time. 