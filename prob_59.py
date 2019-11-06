# Definition for a binary tree node.
# passed leetcode yes
# Time -
# sapce -
# algo : at each level find the nodes and check if they are x and y and check for the x and y parent nodes and if parents dont match then return true else false-- DFS
# algo : at each level find if we found the elements and check if they are found as children of same parent, in tha case return False else True - BFS


# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):  # dfs
    # Solution.x_depth = 0
    # Solution.y_depth = 0
    # Solution.x_parent = TreeNode(0)
    # Solution.y_parent = TreeNode(0)
    def isCousins(self, root, x, y):
        Solution.x_depth = 0
        Solution.y_depth = 0
        Solution.x_parent = TreeNode(0)
        Solution.y_parent = TreeNode(0)
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """

        if not (root):
            return False

        self.helper(root, x, y, 0, None)
        # self.helper(root.right, x, y, 1, root)
        # print(x_parent.val,y_parent.val,x_depth,y_depth)
        return (Solution.x_depth == Solution.y_depth and Solution.x_parent != Solution.y_parent)

    def helper(self, root, x, y, depth, parent):
        # print(x_parent.val,y_parent.val,x_depth,y_depth)
        if not (root):
            return
        if root.val == y:
            Solution.y_depth = depth
            Solution.y_parent = parent
        if root.val == x:
            Solution.x_depth = depth
            Solution.x_parent = parent
        self.helper(root.left, x, y, depth + 1, root)
        self.helper(root.right, x, y, depth + 1, root)


class Solution(object): #bfs
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """

        if not (root):
            return False
        q = []
        q.append(root)
        while q:
            size = len(q)
            x_found = False
            y_found = False
            for i in range(0, size, 1):
                curr = q.pop(0)
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                if curr.left and curr.right:
                    if curr.left.val == y and curr.right.val == x:
                        return False
                    if curr.left.val == x and curr.right.val == y:
                        return False
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            if x_found and y_found:
                return True
        return False  # case when x_found is False and y_found is true
