# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I do level order traversal and at each level check if the elements are present if yes, I add their parents 
# in an array list. If the no of unique parents is more than 1 and not equal to num of inputs then return false
# else true

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        size = 1
        match = [x,y]
        while len(q):
            level = []
            while size > 0:
                node = q.popleft()
                
                if node.left:
                    level.append((node.left, node.val))
                if node.right:
                    level.append((node.right, node.val))
                size -= 1
                
            matches = set()
            for l in level:
                if l[0].val in match:
                    matches.add(l[1])                   
                q.append(l[0])
                size+=1

            if len(matches)>0 and len(matches) < len(match):
                    return False
            elif len(matches)>0 and len(matches) == len(match):
                return True
        return False
            