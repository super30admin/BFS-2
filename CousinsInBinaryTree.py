# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        stack =[(root,1,root.val)]
        res =[]
        while len(stack) !=0:
            node,depth,parent = stack.pop()

            if node is not None:
                if node.val ==x or node.val ==y:
                    res.append((node.val,depth,parent))
                if node.left is not None:
                    stack.append((node.left,depth+1,node.val))
                
                if node.right is not None:
                    stack.append((node.right,depth+1,node.val))
                
        return res[0][1] == res[1][1] and res[0][2] != res[1][2]


        