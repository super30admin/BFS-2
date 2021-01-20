# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Initialize a queue with root node, level is 0 and parent is None
# Iterate over the queue until not empty and then iterate over the size of the queue and pop the node in the queue
# Then check if the node value == x or node value == y and parent is not None then append it to res level and parent
# Then append the node left and right to queue
# If there are 2 tuples in the res break the loop and then iterate over the res
# Check if both the nodes levels are equal and the nodes parents are not equal return True else False


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if not root:
            return False
        if root.val == x or root.val == y:
            return False
        level = 0
        queue = [(root, level, None)]
        res = []
        while queue:
            if len(res) == 2:
                break
            for i in range(len(queue)):
                node, level, parent = queue.pop(0)
                if node.val == x or node.val == y and parent:
                    res.append((level, parent))
                if node.left:
                    queue.append((node.left, level + 1, node.val))
                if node.right:
                    queue.append((node.right, level + 1, node.val))
        for i in range(1, len(res)):
            if res[i - 1][0] == res[i][0] and res[i - 1][1] != res[i][1]:
                return True
        return False