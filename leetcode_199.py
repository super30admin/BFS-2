#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 199: Binary Tree Right Side View
    Link: https://leetcode.com/problems/binary-tree-right-side-view/

    Problem:
    Given the root of a binary tree, imagine yourself standing on the right side of it.
    Return the values of the nodes you can see ordered from top to bottom.

    Approach:
    DFS traversing root → right → left. The first node encountered at each depth is
    the rightmost node visible from that level. Append to result only when visiting
    a depth for the first time (len(result) == height).

    1️⃣ If len(self.result) == height, this is the first node seen at this depth → append.
    2️⃣ Recurse right first, then left.

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(h)
        Recursive call stack depth equals the height of the tree.

"""

from collections import deque
from typing import List, Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # DFS root → right → left; keep the first value seen at each level.
        # Because right subtree is traversed first, the first value at each depth
        # is always the rightmost visible node.
        self.result = []

        def dfs(node, height):
            if not node:
                return

            if len(self.result) == height:
                self.result.append(node.val)

            dfs(node.right, height + 1)
            dfs(node.left, height + 1)

        dfs(root, 0)
        return self.result

    '''
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # At each level pop the queue completely and keep the last value.
        # While popping only pop till the current size, since children will also be added.
        if not root:
            return []
        queue = deque()
        queue.append(root)
        result = []

        while queue:
            size = len(queue)
            lastVal = None
            for i in range(size):
                node = queue.popleft()
                lastVal = node.val

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            result.append(lastVal)

        return result
    '''

    '''
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # None delimiter approach: collect full levels, then take last value of each.
        if not root:
            return []

        queue = deque()
        queue.append(root)
        queue.append(None)
        res = []
        level = []

        while len(queue) > 1:
            node = queue.popleft()

            if not node:
                res.append(level)
                level = []
                queue.append(None)
            else:
                level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        res.append(level)

        return [row[-1] for row in res]
    '''

    '''
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        # DFS root → left → right; keep updating the value at each level.
        # Because left subtree is traversed first, right subtree overwrites any
        # earlier value at the same depth, leaving the rightmost node.
        self.result = []

        def dfs(node, height):
            if not node:
                return

            if len(self.result) <= height:
                self.result.append(node.val)
            else:
                self.result[height] = node.val

            dfs(node.left, height + 1)
            dfs(node.right, height + 1)

        dfs(root, 0)
        return self.result
    '''
