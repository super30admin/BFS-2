"""
Leetcode- https://leetcode.com/problems/cousins-in-binary-tree/ (submitted)
TC- O(N) SC- O(N) BFS
Challenges - coming up with where to put the conditions in BFS and where.
Lecture- https://youtu.be/UWwsFlt_xuo
FAQ-
Optimal approach?
BFS, since we cannot stop DFS after each level to check for our conditions, but we can with BFS, making a better average
time.

Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return
true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.


Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false


Constraints:
The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.
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
    Ideation - BFS O(N) time O(N) space

    There are two conditions for checking cousins in a tree:
        1. The two nodes should not be sharing a same parent.
        2. The two nodes must be in same level (same grandparent)

    Looking at these conditions, we need to do our checks on parents before even adding them to the queue to see if
    they satisfy condition one. Then take care of second condition after the level is complete by checking if we found
    X and Y or not.
    """

    def isCousins(self, root, x, y):
        if root is None:
            return False
        queue = deque()
        queue.append(root)
        isX, isY = False, False
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                if curr.left:
                    if curr.left.val == x:
                        isX = True
                    if curr.left.val == y:
                        isY = True
                    queue.append(curr.left)
                if curr.right:
                    if curr.right.val == x:
                        isX = True
                    if curr.right.val == y:
                        isY = True
                    queue.append(curr.right)

                # if same parents
                if curr.left and curr.right and ((curr.left.val == x and curr.right.val == y) or
                                                 (curr.left.val == y and curr.right.val == x)):
                    return False

            # After level is complete, check if X and Y were found and condition one doesn't satisfy, return true.
            if isX and isY:
                return True
            # return False if one of them is found, which means one was found and the other was missing. Note all
            # elements in the tree are unique
            if isX or isY:
                return False

        return False

    '''
    Ideation- DFS O(N) time and O(1) space
    
    It is tricky with DFS to do what we were doing in BFS where we will do a check after each level. Since, we are going
    depth in DFS, we will have to take a slightly different approach.
    
    If the node is X or Y, we will save its parent and the level and in the end compare them to check our two conditions
    '''

    def isCousins1(self, root, x, y):
        if root is None:
            return False
        self.isX, self.isY = False, False
        self.xLevel, self.yLevel = -1, -1
        self.xParent, self.yParent = None, None
        self.dfs(root, None, 0, x, y)
        return self.isX and self.isY and self.xLevel == self.yLevel and self.xParent != self.yParent

    def dfs(self, root, parent, level, x, y):
        # base
        if root is None:
            return
        # logic
        if root.val == x:
            self.isX = True
            self.xParent = parent
            self.xLevel = level
        if root.val == y:
            self.isY = True
            self.yParent = parent
            self.yLevel = level

        self.dfs(root.left, root, level + 1, x, y)
        self.dfs(root.right, root, level + 1, x, y)


tree = "[1,2,3,null,4]"
root = deserializer(tree)
isCousins = Solution().isCousins1(root, 2, 3)
print(isCousins)
