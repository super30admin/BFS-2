"""
Leetcode - https://leetcode.com/problems/binary-tree-right-side-view/ (submitted)
TC- O(1), SC- O(1) auxiliary
Challenge- NA
Lecture- https://youtu.be/iICZEF2BN24
FAQ-


Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you
can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
"""

from collections import deque
from Driver.TreeSerializerDeserializer import deserializer


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Ideation - DFS O(N) time and O(1) auxiliary space

    The idea here is to save one value for each level of the tree and to make sure the node is the rightmost node
    first, if not then choose left most.
    To achieve this, We call the preorder but have it call right first, if there is no element in the result array for
    that level, create one, but if there don't do anything since we called right first, the element there for that level
    would be the right one.
    """

    def rightSideView(self, root):
        self.result = []
        if root is None:
            return self.result
        self.helper(root, 0)
        return self.result

    def helper(self, root, level):
        if root is None:
            return
        if len(self.result) == level:
            self.result.append(root.val)

        if root.right:
            self.helper(root.right, level + 1)
        if root.left:
            self.helper(root.left, level + 1)

    '''
    Ideation - BFS O(N) time and O(N) space
    
    The idea is the same but doing it using a queue
    '''

    def rightSideView1(self, root):
        result = []
        if root is None:
            return result

        q = deque()
        q.append(root)
        result.append(root.val)
        level = 0
        while q:
            size = len(q)
            for _ in range(size):
                curr = q.popleft()
                if len(result) == level:
                    result.append(curr.val)
                if curr.right:
                    q.append(curr.right)
                if curr.left:
                    q.append(curr.left)
            level += 1

        return result

root = deserializer('[1,2,3,null,5,null,4]')
result = Solution().rightSideView1(root)
print(result)