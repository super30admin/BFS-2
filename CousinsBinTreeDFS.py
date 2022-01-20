# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


'''DFS to find x and y. Set global heights and parents. Validate and return.'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        if not root:
            return False

        x_height = -1
        y_height = -1
        x_parent = None
        y_parent = None
        
        def recur(root, parent, height):
            nonlocal x_height
            nonlocal y_height
            nonlocal x_parent
            nonlocal y_parent
            
            if not root:
                return
            
            if root.val == x:
                x_height = height
                x_parent = parent
            
            if root.val == y:
                y_height = height
                y_parent = parent
            
            if x_parent == None or y_parent == None:
                recur(root.left, root, height + 1)
            
            if x_parent == None or y_parent == None:
                recur(root.right, root, height + 1)
 
        recur(root, None, 0)
        
        if x_height == y_height and y_parent != x_parent:
            return True
        else:
            return False