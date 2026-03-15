#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 993: Cousins in Binary Tree
    Link: https://leetcode.com/problems/cousins-in-binary-tree/

    Problem:
    Two nodes of a binary tree are cousins if they have the same depth but
    different parents. Given the root and two values x and y, return true if
    they are cousins.

    Approach:
    BFS level-by-level. Track foundX, foundY, parentX, parentY within each level.
    If both are found in the same level with different parents → cousins.
    If only one is found in a level → cannot be cousins → False.

    1️⃣ Early exit: if root is x or y, it has no parent → False.
    2️⃣ BFS level by level using queue size snapshot.
    3️⃣ For each node, check if its children are x or y; record parent.
    4️⃣ After each level: if both found and parents differ → True.
    5️⃣ If only one found in this level → False (different depths).

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(n)
        Queue holds at most O(n) nodes at a level.

"""

from collections import deque
from typing import Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False

        foundX = False
        foundY = False
        parentX = None
        parentY = None

        if root.val == x or root.val == y:
            return False

        queue = deque()
        queue.append(root)

        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.popleft()
                if node.left:
                    if node.left.val == x:
                        foundX = True
                        parentX = node
                    if node.left.val == y:
                        foundY = True
                        parentY = node
                    queue.append(node.left)

                if node.right:
                    if node.right.val == x:
                        foundX = True
                        parentX = node
                    if node.right.val == y:
                        foundY = True
                        parentY = node
                    queue.append(node.right)

            if foundX and foundY:
                if parentX == parentY:
                    return False
                return True
            if foundX or foundY:
                return False

        return False
