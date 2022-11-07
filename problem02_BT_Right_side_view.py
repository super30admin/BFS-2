#using BFS since we have to do level order traversal and we need to use queue for BFS
# https://leetcode.com/problems/binary-tree-right-side-view/description/
# Time Complexity : O(n)
# Space Complexity : O(n/2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

import collections
class Solution:
    def rightSideView(self, root):
        res = []
        if root == None:
            return res
        
        q = collections.deque()
        q.append(root)

        while(len(q) != 0):
            prev = None
            size = len(q)
            while(size > 0):
                node = q.popleft()
                
                if(node.left != None):
                    q.append(node.left)
                if(node.right != None):
                    q.append(node.right)
                
                prev = node

                size -=1
            res.append(prev.val)
        return res 

#DFS requires recursion 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recursiveRightSide(self, node, level, res):
        if node == None:
            return
        
        if (len(self.res) == level):
            self.res.append(node.val)

        self.recursiveRightSide(node.right, level + 1, self.res)
        self.recursiveRightSide(node.left, level+1, self.res)

        
    def rightSideView(self, root):
        self.res = []
        self.recursiveRightSide(root, 0, self.res)
        return self.res