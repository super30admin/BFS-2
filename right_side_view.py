# Time Complexity : O(n) n:number of nodes in tree
# Space complexity :O(h) h : height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Traverse the tree recursively always go right before left.
# Pass down the current depth as level when traverseing and then use the length of result array to know exactly how many levels are done.
# If right not present then left will be added to result array as the level of the node will be equal to lenght of result.

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

        result = []
        if root is None:
            return result

        def helper(root,result,level):
            if root is None:
                return

            if len(result) == level:
                result.append(root.val)

            helper(root.right,result,level+1)
            helper(root.left,result,level+1)

        helper(root,result,0)
        return result
    