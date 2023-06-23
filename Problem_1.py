"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

For BFS - 
Itarting over each level, and appending the value of last node processed in that level to the result
in order to get the rightmost node value, in the end, returning the result array


For DFS - 
Maintaining an array, where the indices represent the levels, values inside the specific will be the latest value processed on that level
performing preorder traversal, and updating the value at the specific level in the result array, as the right subtree will be processed
at the last, the result array would be updated accordingly


"""

# Binary Tree Right Side View

# Approach - 1
# BFS

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
        if not root:
            return root
        
        res=[]
        q=collections.deque()
        q.append(root)

        while q:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

            res.append(curr.val)
        return res


# Approach - 2
# DFS

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
        if not root:
            return root
        
        res=[]

        def dfs(root,level):
            if not root:
                return
            if level>=len(res):
                res.append(root.val)
            else:
                res[level]=root.val
            dfs(root.left,level+1)
            dfs(root.right,level+1)


        dfs(root,0)
        return res