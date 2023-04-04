# Time Complexity : O(n)
# Space Complexity : O(D) D is diameter of tree. Let's use the last level to estimate the queue size. This level could contain up to N/2 tree nodes in the case of complete binary tree.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        q = []
        if root == None:
            return []
        q.append(root)
        result = []
        while(len(q) > 0):
            size = len(q)
            for i in range(size):
                temp = q.pop(0)
                if i == size-1:
                    result.append(temp.val)
                if temp.left != None:
                    q.append(temp.left)
                if temp.right != None:
                    q.append(temp.right)
        return result