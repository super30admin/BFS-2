
#// Time Complexity : O(n)
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None:
            return None
        result = []

        def dfs(root,level):
            if root == None:
                return
            if len(result) == level:
                result.append(root.val)
            if root.right:
                dfs(root.right,level + 1)
            if root.left:
                dfs(root.left,level + 1)
        
        dfs(root,0)
        return result
        
        # if root == None:
        #     return None
        # result = []
        # queue = []
        # queue.append(root)
        # while queue:

        #     size = len(queue)
        #     for i in range(size):
        #         abc = queue.pop(0)
        #         if abc.left:
        #             queue.append(abc.left)
        #         if abc.right:
        #             queue.append(abc.right)
        #         if i == (size-1):
        #             result.append(abc.val)
            
        # return result


# Approach
# The DFS approach traverses the tree by prioritizing the right subtree to ensure the rightmost elements at each level are added first.
# The BFS approach uses a queue to perform level-order traversal and captures the last element of each level.