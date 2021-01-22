'''
    Time Complexity:
        O(n) (where n = number of nodes in the Tree)

    Space Complexity:
        O(h) (where h = size of the implicit memory stack)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        DFS approach
        Keep track of the depth and parent of both the nodes.
'''
class Solution:
    def __init__(self):
        self.x = 0
        self.y = 0
        self.x_parent = None
        self.y_parent = None
        self.x_depth = 0
        self.y_depth = 0

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.x = x
        self.y = y
        self.find_location(root, None, 0)

        if self.x_parent == self.y_parent:
            return False

        return self.x_depth == self.y_depth

    def find_location(self, node, parent, depth):
        if node is None:
            return

        if node.val == self.x:
            self.x_parent = parent
            self.x_depth = depth

        if node.val == self.y:
            self.y_parent = parent
            self.y_depth = depth

        self.find_location(node.left, node, depth + 1)
        self.find_location(node.right, node, depth + 1)
