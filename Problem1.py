## Problem 1

# Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

# Method1: Using Normal BFS left to right
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(N/2) = O(N) -- max possible number of leaves in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Doing a level order travesal, we append the last child on each level to our result. Here we do a normal BFS
# going from left to right

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        # using normal BFS 
        # at each level we append the last element of that level to
        # our result
        if(not root):
            return []
        rightView = []
        que = deque([root])

        while(que):
            size = len(que)
            for i in range(size):
                ele = que.popleft()
                if(i == size - 1):
                    # last element of the level
                    rightView.append(ele.val)

                if(ele.left):
                    que.append(ele.left)

                if(ele.right):
                    que.append(ele.right)

        return rightView


node1 = TreeNode(1)
node2 = TreeNode(2)
node22 = TreeNode(2)
node3 = TreeNode(3)
node33 = TreeNode(3)
node4 = TreeNode(4)
node44 = TreeNode(4)
node8 = TreeNode(8)
node88 = TreeNode(8)
node9 = TreeNode(9)
node99 = TreeNode(9)
node10 = TreeNode(10)
node1010 = TreeNode(10)
node2016 = TreeNode(2016)
node1.left = node2
node1.right = node22
node2.left = node3
node2.right = node4
node22.left = node44
node22.right = node33
node3.left = node8
node3.right = node9
node4.left = node10
node44.right = node1010
node33.left = node99
node33.right = node88
node8.left = node2016
print("Method1: Using Normal BFS left to right")
root = node1
sol = Solution()
print(sol.rightSideView(root))
print(sol.rightSideView(None))

# Method2: Using Custom BFS right to left children
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(N/2) = O(N) -- max possible number of leaves in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Using level order traversal as above, just that we add the right element first into the queue.
# In this way we append the first element value we pop at current level

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        # using custom BFS
        # at each level we append the last element of that level to
        # our result
        if(not root):
            return []
        rightView = []
        que = deque([root])

        while(que):
            size = len(que)
            for i in range(size):
                ele = que.popleft()
                if(i == 0):
                    # last element of the level
                    rightView.append(ele.val)

                if(ele.right):
                    que.append(ele.right)
                    
                if(ele.left):
                    que.append(ele.left)

        return rightView

print("Method2: Using Custom BFS right to left children")
sol = Solution()
print(sol.rightSideView(root))
print(sol.rightSideView(None))


# Method3: Using Normal DFS
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(h), h = max height of the tree ie recursive stack space
# h = N in worst case and h = logN in best case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we do normal DFS in preorder way -> root - left - right. So by default we go to the left subtree first
# Whenever we reach a level, we compare with size of result array. If entry for that level does not exists
# then we append the current root value. But value at that level already exists, then we update that value
# to current root value because we are going in root - left - right that we visit the elements on the right side
# later. So every time we get any latest value for a level we update the result for that level as that would be
# the right most value

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.rightView = []

    def rightSideView(self, root):
        def helper(node, currLevel):
            # base
            if(not node):
                return

            if(currLevel == len(self.rightView)):
                # first element for this currLevel
                self.rightView.append(node.val)
            else:
                # we visit this level again with a new value
                # so update the value for the current level
                # with the right most value
                self.rightView[currLevel] = node.val

            helper(node.left, currLevel + 1)
            helper(node.right, currLevel + 1)

        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        # using DFS
        helper(root, 0)
        return self.rightView
    
print("Method3: Using DFS")
sol = Solution()
print(sol.rightSideView(root))
sol = Solution()
print(sol.rightSideView(None))


# Method4: Using Custom DFS
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(h), h = max height of the tree ie recursive stack space
# h = N in worst case and h = logN in best case
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We can do a DFS in the form of root - right - left. In this way, we are always visiting the right subtree
# first. So the first time we visit a level we would get the right view element. So append the element to the 
# result when we first visit the level

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.rightView = []

    def rightSideView(self, root):
        def helper(node, currLevel):
            # base
            if(not node):
                return

            if(currLevel == len(self.rightView)):
                # first element for this currLevel from right view
                self.rightView.append(node.val)
            

            helper(node.right, currLevel + 1)
            helper(node.left, currLevel + 1)

        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        # using DFS
        helper(root, 0)
        return self.rightView
    

print("Method4: Using Custom DFS")
sol = Solution()
print(sol.rightSideView(root))
sol = Solution()
print(sol.rightSideView(None))