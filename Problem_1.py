"""
Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Approach - 1
import collections
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        """
        We will use BFS to iterate over the tree. creating buckets at each level and storing
        the right most element of the bucket. We will return all the stored element
        Time Complexity : O(N)
        Space Compleixty: O(W), width of the tree
        """
        # create a queue
        levels = []
        if not root:
            return levels
        
        q = deque([root,])
      
        while q:
            count = len(q)
           
            for i in range(count):
                curr = q.popleft()
                if i == count - 1:
                    levels.append(curr.val)
                
           
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
             
        
        return levels


# Approach - 2


import collections
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        """
        Using DFS recursive approach, two paths - Path_1: Right_child--Left_Child || Path_2: Left_Child--right_child
        Path_1: if we add element level by level in the result array. if the level matches the len of the
        result then we will add the element.
        Path_2: we will again update the result array with same depth.

        Time Complexity : O(N)
        Space Complexity : O(H), height of teh tree
        """
        if root is None: return []
        
        result = []
        
        def dfs_helper(root, depth, res):
            if depth == len(res): res.append(root.val)
            else: res[depth] = root.val
            
            if root.left:
                dfs_helper(root.left, depth + 1, res)
                
            if root.right:
                dfs_helper(root.right, depth + 1, res)
            
        dfs_helper(root, 0, result)
        
        return result
                
            
        
        