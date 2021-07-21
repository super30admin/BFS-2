
#Time Complexity: O(N).
#Auxiliary Space: O(h)
#Did this code successfully run on Leetcode :Yes



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.result = []
        if not root:
            return root
        
        def inorder(root,level):
            if not root:
                return
            if level == len(self.result):
                self.result.append(root.val)
                
            inorder(root.right,level+1)
            inorder(root.left,level+1)
            
            
            
            
        inorder(root,0)
        return self.result