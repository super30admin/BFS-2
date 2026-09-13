# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        stack = [root]
        parent_stack = [None]
        level_stack = [0]
        x_level = -1
        y_level = -1
        x_parent = None
        y_parent = None

        while stack:
              curr = stack.pop()
              curr_level = level_stack.pop()
              parent = parent_stack.pop()

              if curr.val == x:
                 x_level = curr_level
                 x_parent = parent
              
              if curr.val == y:
                 y_level = curr_level
                 y_parent = parent
              
              if curr.left is not None:
                 stack.append(curr.left)
                 parent_stack.append(curr)
                 level_stack.append(curr_level+1)

              if curr.right is not None:
                 stack.append(curr.right)
                 parent_stack.append(curr)
                 level_stack.append(curr_level+1)
        return x_level == y_level and y_parent != x_parent
                
                 
                  
