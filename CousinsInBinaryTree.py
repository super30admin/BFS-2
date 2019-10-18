#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Oct 18 09:05:35 2019

@author: tanvirkaur
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# time complexity = O(n)
# Space complexity = O(n)
# dfs apprach is used and we check the condition that there depth must be equal and parents not equal

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        stack = [(root,None,0)]
        x_found = False
        y_found = False
        while stack:
            node,par,depth = stack.pop()
            if node.val == x: 
                parx = par
                dx = depth
                x_found = True
            if node.val == y:
                pary = par
                dy = depth
                y_found = True
            if x_found and y_found:
                break
            if node.left:
                stack.append((node.left,node,depth+1))
            if node.right:
                stack.append((node.right,node,depth+1))
        return (dx == dy) and (parx.val != pary.val)