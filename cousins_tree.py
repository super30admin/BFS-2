# Author: Naveen US
# Title: Cousins in Binary Tree

# Time complexity: O(n)
# Space complexity: O(h)
# Did the code run on leetcode: Yes

class Solution:
    def isCousins(self, root, x, y):
        def dfs(node, par, dep, val):
            if not node: return
            if node.val == val: return dep, par
            return dfs(node.left, node, dep + 1, val) or dfs(node.right, node, dep + 1, val)
        
        dep_x, par_x = dfs(root, None, 0, x)
        dep_y, par_y = dfs(root, None, 0, y)

        return dep_x == dep_y and par_x != par_y
