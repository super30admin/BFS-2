# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of the tree
# Did this code successfully run on Leetcode: Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        result=[]
        def helper(root,level):
            # base
            if root is None:
                return
            
            # logic
            if len(result)==level:
                result.append(root.val)
            helper(root.right,level+1)
            helper(root.left,level+1)
        
        helper(root,0)
        return result
        