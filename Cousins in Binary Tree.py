# Time Complexity : O(n) as we go through each node only once
# Space Complexity : O(h) as the stack will contain only either the left side nodes or right side nodes
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english: This code checks whether two nodes x and y in a binary tree are cousins. It performs a DFS, recording each node’s level (depth) and parent, then compares them after traversal. Finally, it returns True if x and y are on the same level but have different parents, which is the definition of cousins in a binary tree.

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        self.x_level = -1
        self.y_level = -1
        self.x_parent = None 
        self.y_parent = None

        def helper(node, level, parent):
            if node is None:
                return
            
            if node.val == x:
                self.x_level = level
                self.x_parent = parent
            
            if node.val == y:
                self.y_level = level
                self.y_parent = parent
            
            helper(node.left, level + 1, node)
            helper(node.right, level + 1, node)

        helper(root, 0, None)
        return self.x_level == self.y_level and self.x_parent != self.y_parent