## Problem 2

# Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

# Method1: Using BFS with keeping track of level and parents
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(N/2) = O(N) -- max possible number of leaves in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here for cousins we need to check two things. 1. They are at same level and 2. Different Parents
# We go interating children level by level. For each node we keep track of their parent. We can do this using
# a tuple in the same queue or we can keep two queues one for BFS and one for the parent of the node
# Once we find x we note its presence and parent. Once we find y we note its presence and parent.
# If presence is at same level and parents are different then they are cousins

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from collections import deque
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        # use BFS to go level by level
        # if we found only one of x or y at a level, then return False
        # if we found both at the same level then check for their parents
        # so we can maintain a tuple of child and their parent

        que = deque()
        que.append((root, None))
        isXFound = False
        isYFound = False
        px = None
        py = None
        while(que):
            for i in range(len(que)):
                ele, eleParent = que.popleft()
                if(ele.val == x):
                    isXFound = True
                    px = eleParent

                if(ele.val == y):
                    isYFound = True
                    py = eleParent

                if(ele.left):
                    que.append((ele.left, ele))

                if(ele.right):
                    que.append((ele.right, ele))

            if(isXFound and isYFound):
                # X and Y are at same level
                return px != py
            
            elif(isXFound or isYFound):
                # only one of them exists at the current level
                return False

        return False

node1 = TreeNode(1)
node2 = TreeNode(2)
node3 = TreeNode(3)
node4 = TreeNode(4)
node5 = TreeNode(5)
node6 = TreeNode(6)
node7 = TreeNode(7)
node8 = TreeNode(8)
node10 = TreeNode(10)
node11 = TreeNode(11)
node12 = TreeNode(12)
node13 = TreeNode(13)

node1.left = node2
node1.right = node3
node2.left = node11
node2.right = node5
node3.left = node10
node3.right = node4
node11.left = node12
node11.right = node13
node5.left = node7
node5.right = node8
node4.left = node6

root = node1

sol = Solution()
print("Method1: Using BFS with keeping track of level and parents")
print(sol.isCousins(root,4,5))
print(sol.isCousins(root,13,7))
print(sol.isCousins(root,8,6))
print(sol.isCousins(root,7,8))


# Method1: Using BFS with keeping track of level
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(N/2) = O(N) -- max possible number of leaves in the queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The algo is same as above. Just that we are checking the two nodes are siblings or not before adding them to the
# queue. They can be sibling only when parent is same. So we are using the benefit of Binary Tree that can have
# at most 2 children. So if they are not siblings and they are at the same level it means they are cousins.
# So no need to keep track of the parents

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        # use BFS to go level by level
        # if we found only one of x or y at a level, then return False
        # if we found both at the same level then check for their parents
        # so we can maintain a tuple of child and their parent

        que = deque()
        que.append(root)
        isXFound = False
        isYFound = False
        while(que):
            for i in range(len(que)):
                ele = que.popleft()
                if(ele.val == x):
                    isXFound = True

                if(ele.val == y):
                    isYFound = True

                # check if they are siblings
                if(ele.left and ele.right):
                    if((ele.left.val == x and ele.right.val == y) or (ele.left.val == y and ele.right.val == x)):
                        # x, y has same parents
                        return False
                if(ele.left):
                    que.append(ele.left)

                if(ele.right):
                    que.append(ele.right)

            if(isXFound and isYFound):
                # X and Y are at same level
                # We have already checked for siblings
                # So they are cousins
                return True
            elif(isXFound or isYFound):
                # only one of them exists at the current level
                return False

        return False

sol = Solution()
print("Using BFS with keeping track of level")
print(sol.isCousins(root,4,5))
print(sol.isCousins(root,13,7))
print(sol.isCousins(root,8,6))
print(sol.isCousins(root,7,8))

# Method3: Using Brute Force DFS
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(h) = h -- max height of the tree that is recursive stack space
# h = N in worst case of skewed tree and h = logN in case of complete balanced binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Here we are using DFS to go through all the nodes passing current level and parent as parameters of recursion
# When we find x or y -- we note their level and parent. Finally we check levels should be same and 
# parents should be different

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.xLevel = None
        self.px = None
        self.yLevel = None
        self.py = None

    def isCousins(self, root, x, y):
        def helper(node, x, y, currLevel, parent):
            if(not node):
                return

            if(node.val == x):
                self.xLevel = currLevel
                self.px = parent

            if(node.val == y):
                self.yLevel = currLevel
                self.py = parent

            helper(node.left, x, y, currLevel + 1, node)
            helper(node.right, x, y, currLevel + 1, node)

        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        helper(root, x, y, 0, None)
        if(self.xLevel == self.yLevel):
            return self.px != self.py
        
        return False
        
sol = Solution()
print("Using Brute Force DFS")
print(sol.isCousins(root,4,5))
print(sol.isCousins(root,13,7))
print(sol.isCousins(root,8,6))
print(sol.isCousins(root,7,8))


# Method3: Using Conditional DFS
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(h) = h -- max height of the tree that is recursive stack space
# h = N in worst case of skewed tree and h = logN in case of complete balanced binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Algo is same as above. Just we are returning once we have got both x and y levels and parents

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.xLevel = None
        self.px = None
        self.yLevel = None
        self.py = None

    def isCousins(self, root, x, y):
        def helper(node, x, y, currLevel, parent):
            if(not node):
                return

            if(self.xLevel != None and self.yLevel != None):
                # we have already found x and y
                return

            if(node.val == x):
                self.xLevel = currLevel
                self.px = parent

            if(node.val == y):
                self.yLevel = currLevel
                self.py = parent

            helper(node.left, x, y, currLevel + 1, node)
            helper(node.right, x, y, currLevel + 1, node)

        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.xLevel = None
        self.px = None
        self.yLevel = None
        self.py = None
        helper(root, x, y, 0, None)
        if(self.xLevel == self.yLevel):
            return self.px != self.py
        
        return False
        
sol = Solution()
print("Using Conditional DFS")
print(sol.isCousins(root,4,5))
print(sol.isCousins(root,13,7))
print(sol.isCousins(root,8,6))
print(sol.isCousins(root,7,8))


# Method3: Using Conditional DFS without parents
# N -- Total number of nodes
# Time Complexity : O(N) -- going through all the nodes
# Space Complexity : O(h) = h -- max height of the tree that is recursive stack space
# h = N in worst case of skewed tree and h = logN in case of complete balanced binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# The algo is same as above. We are checking for siblings before making the right and left recursive calls.
# So if x and y are siblings we set the flag there only. If they are not siblings we keep making recursive calls
# till we find level of x and y. Finally we need to check the sibling flag and compare the levels

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.xLevel = None
        self.yLevel = None
        self.isSibling = False

    def isCousins(self, root, x, y):
        def helper(node, x, y, currLevel):
            if(not node):
                return

            if(self.isSibling):
                return

            if(self.xLevel != None and self.yLevel != None):
                return

            if(node.val == x):
                self.xLevel = currLevel

            if(node.val == y):
                self.yLevel = currLevel

            # check if they are siblings here itself
            if(node.left and node.right):
                if((node.left.val == x and node.right.val == y) or (node.left.val == y and node.right.val == x)):
                    # x and y are siblings
                    self.isSibling = True
                    return

            helper(node.left, x, y, currLevel + 1)
            helper(node.right, x, y, currLevel + 1)

        """
        :type root: Optional[TreeNode]
        :type x: int
        :type y: int
        :rtype: bool
        """
        self.xLevel = None
        self.yLevel = None
        self.isSibling = False
        helper(root, x, y, 0)
        if(self.xLevel == self.yLevel and (not self.isSibling)):
            return True
        
        return False
        
sol = Solution()
print("Using Conditional DFS without parents")
print(sol.isCousins(root,4,5))
print(sol.isCousins(root,13,7))
print(sol.isCousins(root,8,6))
print(sol.isCousins(root,7,8))