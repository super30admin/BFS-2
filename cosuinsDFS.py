"Time Complexity is O(N)"
"Space Complexity is O(H), h is the height of the tree"

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_parent = None
        y_parent = None
        x_level = -1
        y_level = -1

        def helper(node,depth, parent):
            nonlocal x_parent, y_parent, x_level, y_level
        
            if node is None:
                return
            
            if node.val==x:
                x_level = depth
                x_parent = parent
            if node.val == y:
                y_level = depth
                y_parent = parent

            helper(node.left,depth+1, node)
            helper(node.right,depth+1, node)
        
        helper(root,0, None)
        return (x_level == y_level) and (x_parent != y_parent)
        