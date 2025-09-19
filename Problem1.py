# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    # intution : recurssively iterate through the tree (dfs) pass the level of the node as dfs paremeter and in the output result we add the root which will be the right and then in the next level, 
    # we will first itereate the rigth child and then the left child and we check if the queue len is same the level then we add the node value, once added the size is greater and no need to add any value of that level
    # this way we will be iterating the graph frm root to leaf and at every node when the level matches the size then we add the node and no other elements of that level 
    # giving us the right view

    # tc : O(n)
    # sc : recurssive stack O(h)

    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        self.right_view = []
    
        if root is None:
            return self.right_view

        return self.helper(root,0)

    def helper(self, root, level):
        if root is None:
            return

        if len(self.right_view) == level:
            self.right_view.append(root.val)

        self.helper(root.right, level+1)
        self.helper(root.left, level+1)

        return self.right_view


   


        