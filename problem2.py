# Time Complexity : O(n)
# Space Complexity : O(d) where d is height

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        check_map = dict()

        def parser(root, depth=0, parents_val=None):
            if not root:
                return
            if root.val not in check_map:
                check_map[root.val] = [depth, parents_val]
            parser(root.left, depth+1, root.val)
            parser(root.right, depth+1, root.val)
        parser(root)
        x_depth = check_map[x][0]
        x_parents_val = check_map[x][1]
        y_depth = check_map[y][0]
        y_parents_val = check_map[y][1]
        if x_depth == y_depth and x_parents_val != y_parents_val:
            return True
        return False