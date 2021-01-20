# Time Complexity : O(N)
# Space Complexity : O(D)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using BFS. Initialize a queue containing root as a node inside the queue.
# Iterate over the queue until it is not empty and initialize a lvelNodes list
# Iterate over the size of the queue and pop the node and push its left and right child to the queue
# Then append the node value in the levelNodes list
# LevelNodes would contain all the list level by level
# Only append the last node value of each level to res


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if not root:
            return None
        queue = ([root])
        res = []
        while queue:
            levelNodes = []
            for i in range(len(queue)):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
                levelNodes.append(node.val)
            res.append(levelNodes[-1])
        return res
