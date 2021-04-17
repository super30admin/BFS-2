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
        # Do BFS and if you find (x,y) in same level but with different parents
        # Then They are cousins otherwise they are not
        
        # Using DFS Approach
        # Do DFS and store the heights of the nodes, if the nodes have same height and doesn't belong to the same parent then they are cousins.
        # Time Complexity is O(n), where n is the number of nodes
        # Space Complexity is O(h), where h is the height of the tree
        stack = [(root,0)]
        xparent = None
        level1 = None
        yparent = None
        level2 = None
        while(stack):
            curr,level = stack.pop()
            if(curr.val == x):
                level1 = level
            if(curr.val == y):
                level2 = level
            if(level1 is not None and level2 is not None):
                break
            if(curr.right):
                if(curr.right.val == x):
                    xparent = curr
                if(curr.right.val == y):
                    yparent = curr
                stack.append((curr.right,level+1))
            if(curr.left):
                stack.append((curr.left,level+1))
                if(curr.left.val == x):
                    xparent = curr
                if(curr.left.val == y):
                    yparent = curr
        return (level1 == level2) and (xparent != yparent)