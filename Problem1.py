# Time Complexity : O(n) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Use queue to traverse using BFS.
# - For every node store it's parent and level in the dictionary
# - In the end check dictionary for given x and y, Compare It's level and parent


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
#       Covering corner case
        if not root:
            return []
#       Initialziign queue and adding root into the queue.
        q = []
        q.append(root)
        level = 0
#       Initialize dictionary
        data = {}
#       Adding root node in the dictionary, where parent is None and level is 0
        data[root.val] = (None, level)
#       Running BFS until queue is empty
        while q:
#           Storing length
            lq = len(q)
#           Running for loop for length of previous queue
            for i in range(lq):
#               Poping element from the queue
                current = q.pop(0)
#               Check if left Node is available
                if current.left:
#                   Store left node's value as Key and store current node as parent. also store level.
                    data[current.left.val] = (current.val, level + 1)
#                   Append left element in the queue
                    q.append(current.left)
#               Check if right Node is available
                if current.right:
#                   Store right node's value as Key and store current node as parent. also store level.
                    data[current.right.val] = (current.val, level + 1)
#                   Append right element in the queue
                    q.append(current.right)
#           Increment level by 1
            level += 1
    
#       Check if level is same for x and y
        if data[x][1] == data[y][1]:
#           Check that parent is not same for x and y
            if data[x][0] != data[y][0]:
                return True
            else:
                return False
        else:
            return False
        
