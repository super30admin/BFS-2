 ##Time Complexity : O(n)
##Space Complexity : O(h)
##Did this code successfully run on Leetcode : Yes
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
        queue = collections.deque()
        queue.append((root,0))
        distance={}
        while queue:
            node,depth = queue.popleft()
            if node.left:
                distance[node.left.val]=(node.val,depth+1)
                queue.append((node.left,depth+1))
            if node.right:
                distance[node.right.val]=(node.val,depth+1)
                queue.append((node.right,depth+1))
        if x not in distance or y not in distance: return False
        x_parent,x_depth = distance[x]
        y_parent,y_depth = distance[y]
        return x_depth == y_depth and x_parent != y_parent