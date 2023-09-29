# Time Complexity: O(n)
# Space Complexity: O(h)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        dict = {}
        def helper(root,parent,depth,x,y):
            if not root:
                return
            
            helper(root.left, root, depth+1, x, y)
            helper(root.right, root, depth+1, x, y)

            if root.val == x or root.val == y:
                dict[root.val] = [parent,depth]
        helper(root,None,0,x,y)
        res = dict.get(x) and dict.get(y) and dict[x][0] != dict[y][0] and dict[x][1] == dict[y][1]

        return res
